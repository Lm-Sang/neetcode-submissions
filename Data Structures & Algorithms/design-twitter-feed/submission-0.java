class Twitter {

    private static class Tweet {
        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }
    private Map<Integer, Tweet> tweets;
    private Map<Integer, Set<Integer>> following;
    private int timestamp;
    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, timestamp++);
        tweet.next = tweets.get(userId);
        tweets.put(userId, tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Tweet> maxHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));
        if (tweets.containsKey(userId)) {
            maxHeap.offer(tweets.get(userId));
        }
        Set<Integer> followees = following.get(userId);

        if (followees != null) {
            for (int followeeId : followees) {
                if (tweets.containsKey(followeeId)) {
                    maxHeap.offer(tweets.get(followeeId));
                }
            }
        }
        while (!maxHeap.isEmpty() && result.size() < 10) {
            Tweet tweet = maxHeap.poll();
            result.add(tweet.tweetId);
            if (tweet.next != null) {
                maxHeap.offer(tweet.next);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        following
            .computeIfAbsent(followerId, k -> new HashSet<>())
            .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = following.get(followerId);
        if (followees != null) {
            followees.remove(followeeId);
        }
    }
}