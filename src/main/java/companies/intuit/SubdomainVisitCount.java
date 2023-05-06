package companies.intuit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A website domain "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com" and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.
 * <p>
 * A count-paired domain is a domain that has one of the two formats "rep d1.d2.d3" or "rep d1.d2" where rep is the number of visits to the domain and d1.d2.d3 is the domain itself.
 * <p>
 * For example, "9001 discuss.leetcode.com" is a count-paired domain that indicates that discuss.leetcode.com was visited 9001 times.
 * Given an array of count-paired domains cpdomains, return an array of the count-paired domains of each subdomain in the input. You may return the answer in any order.
 * <p>
 * Example:
 * Input: cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * Output: ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * Explanation: We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times.
 * For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
 */
public class SubdomainVisitCount {
    public static void main(String[] args) {
        final String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        //System.out.println(subdomainVisits(cpdomains));

        System.out.println(subdomainVisitsOptimized(cpdomains));
    }

    private static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        for (String domain : cpdomains) {
            String[] tokens = domain.split(" ");
            int freq = Integer.parseInt(tokens[0]);
            domain = tokens[1];

            int start = 0;
            int pid = 0;
            while (pid >= 0) {
                pid = domain.indexOf(".", start);
                String prefix = domain.substring(start);
                counts.put(prefix, freq + counts.getOrDefault(prefix, 0));
                start = pid + 1;
            }
        }
        List<String> ans = new ArrayList<>(counts.size());
        counts.forEach((k, v) -> ans.add(v + " " + k));
        return ans;
    }

    private static List<String> subdomainVisitsOptimized(String[] cpdomains) {
        HashMap<String, HelperClass> countMap = new HashMap<>();
        for (String strDomain : cpdomains) {
            int current = 0;
            int counter = 0;
            int n = strDomain.length();

            while (strDomain.charAt(current) != ' ') {
                counter = 10 * counter + strDomain.charAt(current++) - 48;
            }

            ++current;

            while (current > 0) {
                String next = strDomain.substring(current, n);
                HelperClass v = countMap.get(next);

                if (v == null) countMap.put(next, new HelperClass(counter));
                else v.inc(counter);

                current = strDomain.indexOf('.', current) + 1;
            }
        }

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, HelperClass> pair : countMap.entrySet()) {
            result.add(sb.append(pair.getValue().value).append(' ').append(pair.getKey()).toString());
            sb.setLength(0);
        }
        return result;
    }

    static class HelperClass {
        int value;

        public HelperClass(int value) {
            this.value = value;
        }

        void inc(int v) {
            value += v;
        }
    }
}
