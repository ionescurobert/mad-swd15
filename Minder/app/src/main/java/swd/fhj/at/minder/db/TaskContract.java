package swd.fhj.at.minder.db;

import android.provider.BaseColumns;

public class TaskContract {
    public static final String DB_NAME = "swd.fhj.at.minder";
    public static final int DB_VERSION = 1;

    public class TaskEntry implements BaseColumns {
        public static final String TABLE = "tasks";

        public static final String COL_TASK_TITLE = "title";
        public static final String COL_TASK_STATE = "state";
    }
}
