class MyHashSet {
    ArrayList<Integer> set;
    public MyHashSet() {
        set=new ArrayList<>();
    }
    
    public void add(int key) {
        if(!contains(key)) set.add(key);
    }
    
    public void remove(int key) {
        int ind=-1;
        for(int i=0;i<set.size();i++){
            if(set.get(i)==key){
                ind=i;
                break;
            }
        }
        if(ind!=-1) set.remove(ind);
    }
    
    public boolean contains(int key) {
        boolean exist=false;
        for(int i=0;i<set.size();i++){
            if(set.get(i)==key){
                exist=true;
                break;
            }
        }
        return exist;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */