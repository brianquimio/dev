package random;

import java.util.LinkedList;

public class DirectoryPath {

    //given String representing file path return path with . and .. removed
    //  ~/a/b/c/../d/ ==> ~/a/b/d/
    //  ~/a/b/./c/ ==> ~/a/b/c/
    //  ~/a/b/c/../../d/ ==> ~/a/d/

    public static String removeDots(String url){
        LinkedList<String> removed = new LinkedList<>();
        String[] tokens = url.split("/");
        for(String token : tokens){
            if(token.equals("."))
                continue;
            else if(token.equals("..")){
                if(removed.isEmpty()){
                    // failure
                }
                else {
                    removed.removeLast();  //LinkedList removeLast()
                }
            }
            else {
                removed.add(token);
            }
        }

        String ret = "";

        for(String s: removed){
            ret += s + "/";
        }

        return ret;
    }

    public static void main(String[] args) {

        System.out.println(removeDots("~/a/./b/c/../../d/"));
    }
}
