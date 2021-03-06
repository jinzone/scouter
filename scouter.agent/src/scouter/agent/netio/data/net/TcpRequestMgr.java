package scouter.agent.netio.data.net;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import scouter.agent.Configure;
import scouter.util.ThreadUtil;

public class TcpRequestMgr extends Thread {

	private static TcpRequestMgr instance;

	public static synchronized TcpRequestMgr getInstance() {
		if (instance == null) {
			instance = new TcpRequestMgr();
			instance.setName("SCOUTER-TCP");
			instance.setDaemon(true);
			instance.start();
		}
		return instance;
	}

	protected Executor pool = ThreadUtil.createExecutor("SCOUTER", 10, 10, true);

	@Override
	public void run() {

		while (true) {
			int cnt = Configure.getInstance().server_tcp_session_count;
			ThreadUtil.sleep(1000);
			try {
				for (int i = 0; i < cnt && TcpWorker.LIVE.size() < cnt; i++) {
					TcpWorker w = new TcpWorker();
					if (w.prepare()) {
						pool.execute(w);
					} else {
						ThreadUtil.sleep(3000);
					}
				}
				while (TcpWorker.LIVE.size() > cnt) {
					TcpWorker w = TcpWorker.LIVE.removeFirst();
					w.close();
				}
			} catch (Throwable t) {
			}
		}
	}
}
