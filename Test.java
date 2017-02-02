package algorithm_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}
//class ListNode {
//	int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}

public class Test {
	/** Initialize your data structure here. */
    class Tweet{
        int time;
        int tid;
        Tweet(int t, int tweetid){
            time=t;
            tid = tweetid;
        }
    }
    int timestamp;
    Map<Integer, List<Tweet>> timelines;
    Map<Integer, HashSet<Integer>> relations;
    public Test() {
        timestamp =0;
        timelines = new HashMap<Integer, List<Tweet>>();
        relations = new HashMap<Integer, HashSet<Integer>>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!timelines.containsKey(userId)){
            timelines.put(userId, new ArrayList<Tweet>());
        }
        timelines.get(userId).add(new Tweet(timestamp++, tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> tweets = timelines.get(userId);
        List<Tweet> candidates = new ArrayList<Tweet>();
        for(int i=tweets.size()-1; i >= Math.max(0, tweets.size()-10) ;i--)
            candidates.add(tweets.get(i));
        HashSet<Integer> followees = relations.get(userId);
        if(followees!=null){
            for(int followee: followees){
                List<Tweet> ftweets = timelines.get(followee);
                for(int i=ftweets.size()-1; i >= Math.max(0, ftweets.size()-10) ;i--)
                    candidates.add(ftweets.get(i));
            }
        }
        Collections.sort(candidates, (Tweet t1, Tweet t2) -> (t2.time - t1.time));
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<Math.min(10, candidates.size());i++)
            res.add(candidates.get(i).tid);
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId)
            return;
        if(!relations.containsKey(followerId))
            relations.put(followerId, new HashSet<Integer>());
        relations.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> set = relations.get(followerId);
        if(set == null)
            return;
        set.remove(followeeId);
    }
    
    public static void main(String[] args) {
		Test twitter = new Test();
		List<Integer> res  = new ArrayList();
		// User 1 posts a new tweet (id = 5).
		twitter.postTweet(1, 1);

		// User 1's news feed should return a list with 1 tweet id -> [5].
		twitter.getNewsFeed(1);

		// User 1 follows user 2.
		twitter.follow(2, 1);

		// User 2 posts a new tweet (id = 6).
		res =twitter.getNewsFeed(2);
		for(int i: res)
			System.out.print( i + " " );
		System.out.println();
		
		twitter.unfollow(2,1);
		
		// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
		// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		twitter.getNewsFeed(2);

	}
}