package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

//Baidu 

public class FileSystem {
	class File{
        String name;
        String content;
        public File(String name){
            name = name;
            content="";
        }
        
        public File(String name, String cnt){
            this.name = name;
            content+=cnt;
        }
        
    }
    
    class Folder{
        String name;
        HashSet<File> files;
        HashSet<Folder> folders;
        
        class fileComparator implements Comparator<File>{
        	public int compare(File f1, File f2){
        		String name1 = f1.name.toLowerCase();
        		String name2 = f2.name.toLowerCase();
        		return name1.compareTo(name2);
        	}
        }
        
        public Folder(String n){
            this.name = n;
            files = new HashSet<File>();
            folders = new HashSet<Folder>();
        }
    }
    
    Folder root;
    
    public FileSystem() {
        root = new Folder("root");
    }
    
    public List<String> ls(String path) {
    	Folder f = root;
    	List<String> res = new ArrayList();
    	
    	boolean folderExist = false, fileExist = false;
    	
    	String[] parts=path.split("/");
    	int i=1;
    	for(;i<parts.length;i++){
    		String fName = parts[i];
    		folderExist = false;
    		for(Folder folder : f.folders){
    			if(folder.name == fName){
    				f = folder;
    				folderExist = true;
    				res.add(parts[i]);
    				break;
    			}
    		}
    		if(!folderExist){
    			for(File file : f.files){
    				if(file.name.equals(parts[i])){
    					res.add(parts[i]);
    					fileExist = true;
    					break;
    				}
    			}
    		}
    	}
    	if(!folderExist && !fileExist)
    		return new ArrayList();
    	if(folderExist && !fileExist){
    		for(Folder folder: f.folders)
    			res.add(folder.name);
    		for(File file : f.files)
    			res.add(file.name);
    	}
    	Collections.sort(res);
    	return res;
    }
    
    public void mkdir(String path) {
        String[] parts=path.split("/");
        if(parts.length<=1)
        	return;
        Folder f = root;
        for(int i=1;i<parts.length;i++){
        	boolean exist = false;
            for(Folder folder: f.folders){
            	if(folder.name.equals(parts[i])){
            		f = folder;
            		exist = true;
            		break;
            	}
            }
            if(!exist){
            	Folder folder = new Folder(parts[i]);
            	f.folders.add(folder);
            	f = folder;
            }
        }
        f = root;
        for(Folder folder: f.folders){
        	if(!folder.name.equals("")){
        		System.out.println(folder.name);
        		f = folder;
        	}
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] parts = filePath.split("/");
        
    }
    
    public String readContentFromFile(String filePath) {
        return "";
    }
    
    public static void main(String[] args) {
    	FileSystem fs = new FileSystem();
    	String path = "/a/b/c", filePath="";
    	String content = "Hello";
    	fs.mkdir(path);
    	List<String> p1 = fs.ls(path);
    	for(String str : p1)
    		System.out.print(str+" ");
    	//fs.addContentToFile(filePath,content);
    	//String param_4 = fs.readContentFromFile(filePath);
	}
}
