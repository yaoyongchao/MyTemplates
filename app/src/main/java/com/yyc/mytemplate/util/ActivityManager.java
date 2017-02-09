package com.yyc.mytemplate.util;

import android.app.Activity;
import android.content.Context;

import java.util.Stack;

/**
 * @author: Andy Yao
 * @date: 2016/1/7 15:55
 * @description: The activity stack type management
 */
public class ActivityManager {

    /**
     * Accept the activity stack.
     */
    private static Stack<Activity> activityStack;
    private static ActivityManager instance;
    private String s;
    private ActivityManager(){}

    /**
     * @return
     * A single instance.
     */
    public static ActivityManager getInstance(){
        if (instance == null) {
            instance = new ActivityManager();
        }
        return instance;
    }

    /**
     * @param activity
     * add activity
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }


    /**
     * @return Activity
     * Gets the current Activity (stack last pressed into).
     */
    public Activity currentActivity(){
        Activity activity = null;
        if(!activityStack.empty()) {
            activity = activityStack.lastElement();
        }
        return activity;
    }

    /**
     * The last of the end of the current Activity (stack into).
     */
    public void finishActivity(){
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * @param activity
     * The end of the specified Activity.
     */
    public void finishActivity(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * @param cls
     * End of the specified class name of the Activity.
     */
    public void finishActivity(Class<?> cls) {
        for(Activity activity : activityStack){
            if(activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }
        }
    }

    /**
     * End all the Activity.
     */
    public void finishAllActivity() {
        for (int i = 0; i < activityStack.size(); i++) {
            if (null != activityStack.get(i)) {
                finishActivity(activityStack.get(i));
                break;
            }
        }
        activityStack.clear();
    }

    /**
     * @param cls
     * @return
     * Access to the specified Activity.
     */
    public static Activity getActivity(Class<?> cls) {
        if (activityStack != null) {
            for (Activity activity:
                 activityStack) {
                if(activity.getClass().equals(cls)) {
                    return activity;
                }
            }
        }
        return null;
    }

    /**
     * Exit the application
     */
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            // Kill the application process
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
        }
    }

}
