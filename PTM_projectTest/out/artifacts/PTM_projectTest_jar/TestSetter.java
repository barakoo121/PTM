package test;

import server_side.*;

import java.util.List;

public class TestSetter {
	

	static Server s; 
	
	public static void runServer(int port) {
		// put the code here that runs your server

		CacheManager cm = new FileCacheManager();
		Searcher<Pair<Integer,Integer>> searcher = new BestFirstSearch<>();

		Solver<Searchable<Pair<Integer, Integer>>,
				List<State<Pair<Integer, Integer>>>> solver = new SearcherAdapter<>(searcher);

		ClientHandler c1 = new MyClientHandler(solver, cm);
		s = new MySerialServer();

		s.start(port, c1);
	}

	public static void stopServer() {
		s.stop();
	}
	

}
