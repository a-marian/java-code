package dfs;
/***
 * 839. Similar String Groups
 * Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.
 * Also two strings X and Y are similar if they are equal. For example, "tars" and "rats" are similar
 * (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".
 * Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars"
 * and "arts" are in the same group even though they are not similar.
 * Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.
 *
 * We are given a list strs of strings where every string in strs is an anagram of every other string in strs.
 * How many groups are there?
 * Example 1:
 * Input: strs = ["tars","rats","arts","star"]
 * Output: 2
 * https://leetcode.com/problems/similar-string-groups/description/
 */
public class SimilarStringGroups {

    public int numSimilarGroups(String[] strs) {
        int res = 0;
        boolean[] visited = new boolean[strs.length];

        for(int i =0; i < strs.length; ++i){
            if(!visited[i]){
                dfs(strs, i, visited);
                ++res;
            }
        }
        return res;
    }

    private void dfs(final String[] strs, int index, boolean[] visited){
        visited[index] = true;
        for(int i=0; i < strs.length; ++i)
            if(!visited[i] && isSimilar(strs[index], strs[i]))
                dfs(strs, i, visited);
    }

    private boolean isSimilar(final String x, final String y){
        int diff = 0;
        for(int i=0; i < x.length(); ++i)
            if(x.charAt(i) != y.charAt(i) && ++diff > 2)
                return false;
        return true;
    }
}
