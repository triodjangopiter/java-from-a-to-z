package ru.pravvich.jdbc;

import java.sql.SQLException;

/**
 * Join to database which executor.
 */
public interface DBJoint {

    ScriptExecutor getDBScriptExecutor() throws SQLException;

    void closeConnection();

}
