package com.HuiShengTec.base.pushletCore;

import com.HuiShengTec.utils.Toolkit;

import nl.justobjects.pushlet.core.Dispatcher;
import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.EventSource;
import nl.justobjects.pushlet.util.Log;

/**
 * Abstract Event source from which Events are pulled.
 *
 * @version $Id: EventPullSource.java,v 1.15 2007/11/23 14:33:07 justb Exp $
 * @author Just van den Broecke - Just Objects &copy;
 **/

/**
 * ABC for specifc EventPullSources.
 */
abstract public class EventPullSource implements EventSource, Runnable {
	private volatile boolean alive = false;
	private volatile boolean active = false;
	private static int threadNum = 0;
	private Thread thread;

	public EventPullSource() {
	}

	abstract protected long getSleepTime();

	abstract protected Event pullEvent();

	public void start() {
		thread = new Thread(this, "EventPullSource-" + (++threadNum));
		thread.setDaemon(true);
		thread.start();
	}

	public boolean isAlive() {
		return alive;
	}

	/**
	 * Stop the event generator thread.
	 */
	public void stop() {
		alive = false;

		if (thread != null) {
			thread.interrupt();
			thread = null;
		}

	}

	/**
	 * Activate the event generator thread.
	 */
	synchronized public void activate() {
		if (active) {
			return;
		}
		active = true;
		if (!alive) {
			start();
			return;
		}
		Log.debug(getClass().getName() + ": notifying...");
		notifyAll();
	}

	/**
	 * Deactivate the event generator thread.
	 */
	public void passivate() {
		if (!active) {
			return;
		}
		active = false;
	}

	/**
	 * Main loop: sleep, generate event and publish.
	 */
	public void run() {
		Log.debug(getClass().getName() + ": starting...");
		alive = true;
		while (alive) {
			try {

				Thread.sleep(getSleepTime());
				if (!alive) {
					break;
				}
				synchronized (this) {
					while (!active) {
						Log.debug(getClass().getName() + ": waiting...");
						wait();
					}
				}

			} catch (InterruptedException e) {
				break;
			}

			try {
				Event event = pullEvent();
				if(!Toolkit.isEmpty(event)){
					//多播模式 后期需要修改
					Dispatcher.getInstance().multicast(event);
				}
				
			} catch (Throwable t) {
				Log.warn("EventPullSource exception while multicasting ", t);
				t.printStackTrace();
			}
		}
		Log.debug(getClass().getName() + ": stopped");
	}
}
