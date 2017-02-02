package algorithm_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//Amazon Twitter

public class Twitter {
	/**
	 * 需要定义一个表示每一条状态的，主要是时间id，以及重新定义排序的
	 * 
	 */
	class Tweet {
		public int time;
		public int tweetId;

		public Tweet(int tweetId, int time) {
			this.time = time;
			this.tweetId = tweetId;
		}

	}

	int timeStamp;
	// 每个人发布的推特信息
	HashMap<Integer, List<Tweet>> timelines;
	// 人际关系，会重复follow所以要用set
	HashMap<Integer, HashSet<Integer>> relations;

	/** Initialize your data structure here. */
	public Twitter() {
		this.timelines = new HashMap<Integer, List<Tweet>>();
		this.relations = new HashMap<Integer, HashSet<Integer>>();

	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if (timelines.containsKey(userId) == false) {
			timelines.put(userId, new ArrayList<Tweet>());
		}
		timelines.get(userId).add(new Tweet(tweetId, timeStamp++));

	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	/**
	 * 全部都选前10，然后按照时间戳排序，注意要选择自己的和别人的
	 */
	public List<Integer> getNewsFeed(int userId) {
		HashSet<Integer> followees = relations.get(userId);
		List<Tweet> candidates = new ArrayList<Tweet>();
		// 分别选择，可以选择每个人的前10条就好
		List<Tweet> timeline = timelines.get(userId);
		if (timeline != null) {
			for (int i = timeline.size() - 1; i >= Math.max(0, timeline.size() - 10); i--) {
				candidates.add(timeline.get(i));
			}
		}
		if (followees != null) {
			for (Integer followee : followees) {
				timeline = timelines.get(followee);
				if (timeline == null)
					continue;
				for (int i = timeline.size() - 1; i >= Math.max(0, timeline.size() - 10); i--) {
					candidates.add(timeline.get(i));
				}
			}
		}
		// Collections.sort(candidates,new Comparator<Tweet> (){
		// public int compare(Tweet o1, Tweet o2) {
		// return o2.time - o1.time;
		// }
		// });
		Collections.sort(candidates, (Tweet o1, Tweet o2) -> (o2.time - o1.time));

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < Math.min(10, candidates.size()); i++) {
			list.add(candidates.get(i).tweetId);
		}
		return list;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		if (followerId == followeeId)
			return;
		if (relations.containsKey(followerId) == false) {
			relations.put(followerId, new HashSet<Integer>());
		}
		relations.get(followerId).add(followeeId);

	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		HashSet<Integer> list = relations.get(followerId);
		if (list == null)
			return;
		list.remove(followeeId);
	}
	
	public static void main(String[] args) {
		Twitter twitter = new Twitter();
		List<Integer> res  = new ArrayList();
		// User 1 posts a new tweet (id = 5).
		twitter.postTweet(1, 5);

		// User 1's news feed should return a list with 1 tweet id -> [5].
		twitter.getNewsFeed(1);

		// User 1 follows user 2.
		twitter.follow(1, 2);

		// User 2 posts a new tweet (id = 6).
		twitter.postTweet(2, 6);

		// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
		// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		res = twitter.getNewsFeed(1);
		for(int i: res)
			System.out.print( i + " ");
		System.out.println();

		// User 1 unfollows user 2.
		twitter.unfollow(1, 2);

		// User 1's news feed should return a list with 1 tweet id -> [5],
		// since user 1 is no longer following user 2.
		res= twitter.getNewsFeed(1);

		for(int i: res)
			System.out.print( i + " ");
		System.out.println();
	}
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */