package org.apache.karaf.main.lock;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.felix.utils.properties.Properties;
import org.apache.karaf.main.lock.DefaultJDBCLock;
import org.apache.karaf.main.lock.Statements;

/**
 * The Class MSSQLServerJDBCLock.
 * 
 * @author Rupesh Raut
 */
public class MSSQLServerJDBCLock extends DefaultJDBCLock {

	final Logger LOG = Logger.getLogger(this.getClass().getName());

	/**
	 * Instantiates a new SQL server JDBC lock.
	 *
	 * @param properties
	 *            the properties
	 */
	public MSSQLServerJDBCLock(Properties properties) {
		super(properties);
		LOG.log(Level.INFO, "creating an instance of MSSQLServerJDBCLock");
	}

	/**
	 * Creates the statements.
	 *
	 * @return the statements
	 */
	@Override
	Statements createStatements() {
		LOG.log(Level.INFO, String.format("creating MsSQLServerStatements with table %s and cluster name %", super.table, super.clusterName));
		final Statements statements = new MsSQLServerStatements();
		statements.tableName = super.table;
		statements.nodeName = super.clusterName;
		return statements;
	}

	/**
	 * The Class MsSQLServerStatements.
	 */
	private static class MsSQLServerStatements extends Statements {

		/**
		 * Gets the lock create statement.
		 *
		 * @return the lock create statement
		 * @see org.apache.karaf.main.lock.Statements#getLockCreateStatement()
		 */
		@Override
		public String getLockCreateStatement() {
			return "SELECT * FROM " + getFullLockTableName();
		}

	}

}