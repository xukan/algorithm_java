package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


class MoviePlay {
	/*
	 * 
	 * 给一串movie，假定每个movie都是一个小时，并且都在整点播放；给你一个List的movies，让你安排播放时间，
	 * 如果没有答案throw一个exception。 比如 
	 * 电影A: 14, 15, 16, 17. 
	 * 电影B: 14, 15, 16. 
	 * 电影C: 14, 15 
	 * 电影D: 14, 15, 17 
	 * 返回一个解就行，比如 A 14, B 16, C 15, D 17。 如果你要 A 14, B 15, 后面 C就没法看了.
	 */
	class Movie {
		String name;
		int time;

		public Movie(String name, int time) {
			this.name = name;
			this.time = time;
		}

		public String toString() {
			return name + ":" + time;
		}
	}

	public List<Movie> arrange(Map<String, List<Integer>> movies) throws Exception {
		List<Movie> res = new ArrayList<>();
		if (helper(res, new HashSet<>(), movies, new ArrayList<>(movies.keySet()), 0))
			return res;
		throw new Exception("No valid arrangement");
	}

	public boolean helper(List<Movie> res, Set<Integer> timeTaken, Map<String, List<Integer>> times,
			List<String> movieList, int index) {
		if (index == movieList.size())
			return true;
		String movie = movieList.get(index);
		List<Integer> playtime = times.get(movie);
		for (Integer time : playtime) {
			if (!timeTaken.contains(time)) {
				timeTaken.add(time);
				res.add(new Movie(movie, time));
				if (helper(res, timeTaken, times, movieList, index + 1))
					return true;
				res.remove(res.size() - 1);
				timeTaken.remove(time);
			}
		}
		return false;
	}

	public static void main(String[] args){
	    Map<String, List<Integer>> movies = new HashMap<>();
	    movies.put("A", new ArrayList());
	    movies.put("B", new ArrayList());
	    movies.put("C", new ArrayList());
	    movies.put("D", new ArrayList());
	    movies.get("A").addAll(Arrays.asList(14, 15, 16, 17));
	    movies.get("B").addAll(Arrays.asList(14, 15, 16));
	    movies.get("C").addAll(Arrays.asList(14, 15));
	    movies.get("D").addAll(Arrays.asList(14, 15, 16, 17));
	    MoviePlay m = new MoviePlay();
	    try{
	        List<Movie> res = m.arrange(movies);
	        Collections.sort(res, new Comparator<Movie>(){
	    		public int compare(Movie m1, Movie m2){
	    			return Integer.compare(m1.time, m2.time);
	    		}
	    	});
	        System.out.println(res);
	    }catch (Exception e){
	        e.printStackTrace();
	    }
	}
}
