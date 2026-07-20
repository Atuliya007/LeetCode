class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> arr=new ArrayList<>();
        Boolean flag=false;
        int max=0;
        for(int i=0;i<candies.length;i++){
            if(max<candies[i]){
                max=candies[i];
            }
        }

        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=max){
                flag=true;
                arr.add(flag);
            }
            else{
                flag=false;
                arr.add(flag);
            }
        }
        return arr;
    }
}