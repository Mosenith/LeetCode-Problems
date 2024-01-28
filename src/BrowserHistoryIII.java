public class BrowserHistoryIII {
    // ***************** 3rd Method ******************
    // Approach 3: Use String[] to store history with len 101
    // curPage - keep track of cur position we're at
    // maxPage - update to curPage every visit(), is used to set the maxLen of steps we can go forward()
    // So in forward() => min(maxPage, curPage+steps)
    // In back() => max(0,curPage-steps)
    // Runtime  : 53ms         -> + 53.42%
    // Memory   : 50.56MB      -> + 43.81%
    String[] history;
    int curPage;
    int maxPage;
    public BrowserHistoryIII(String homepage) {
        curPage =0;
        maxPage = 0;
        history = new String[101];
        history[curPage] = homepage;
    }

    public void visit(String url) {
        curPage++;
        history[curPage] =url;
        maxPage = curPage;
    }

    public String back(int steps) {
        curPage = Math.max(0, curPage - steps);
        return history[curPage];
    }

    public String forward(int steps) {
        curPage = Math.min(maxPage, curPage + steps);
        return history[curPage];
    }
    //  ***************** End of 3rd Method ******************
}
