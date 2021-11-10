/*
 * 929. Unique Email Addresses:
 * 
 * Every valid email consists of a local name and a domain name, separated by 
 * the '@' sign. Besides lowercase letters, the email may contain one or more
 *  '.' or '+'.
 * 
 * If you add periods '.' between some characters in the local name part of an 
 * email address, mail sent there will be forwarded to the same address without
 * dots in the local name. Note that this rule does not apply to domain names.
 * 
 * If you add a plus '+' in the local name, everything after the first plus 
 * sign will be ignored. This allows certain emails to be filtered. Note that 
 * this rule does not apply to domain names.
 * 
 * It is possible to use both of these rules at the same time.
 * 
 * Given an array of strings emails where we send one email to each email[i], 
 * return the number of different addresses that actually receive mails.
 */

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>();
        
        for (String email : emails) {
            String[] parts = email.toLowerCase().strip().split("@");
            String local = new String(parts[0].split("\\+")[0]).replace(".", "");
            String domain = new String(parts[1]);
            
            String whole = local + "@" + domain;
            uniqueEmails.add(whole);
        }
        
        return uniqueEmails.size();
    }
}

/**
 * Notes:
 * 
 * Good practice with String methods: split, replace.
 * 
 * Also good reminder for double escape characters for ++, i.e. "\\+".
 * 
 * In an interview, would ask clarifying questions to determine if strip() and
 * toLowerCase() are needed.
 * 
 * Could also tighten up style here. No need to store local and domain in vars.
 * Enough to just split off local/domain and pre/post + parts of local, then
 * return joined string with replace. More elegant solution.
 */
