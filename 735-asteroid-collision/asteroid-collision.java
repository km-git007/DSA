class Solution {
    public int[] asteroidCollision(int[] asteroids) 
    {
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<asteroids.length;i++) 
        {
            // Positive element encountered then simply add it to the list.
            if(asteroids[i]>0)
            list.add(asteroids[i]);

            // Negative element encountered
            else 
            {
                // To keep track of blast. For example asteroids = [10, -10]
                boolean blast=false;

                // Keep popping till you either empty the list or you keep encountering a positive element
                // at the back of the list having value less than the absolute value of the current negative element.
                while(!list.isEmpty() && list.get(list.size()-1)>0 && list.get(list.size()-1)<=Math.abs(asteroids[i])) 
                {
                    if(list.get(list.size()-1)==Math.abs(asteroids[i])) 
                    {
                        blast=true;
                        list.remove(list.size()-1);
                        break;
                    }
                    list.remove(list.size()-1);
                }

                // Add the current negative element to the list if the list is empty or you've encountered a 
                // negative element at the back of the list and no blast has occurred.
                // Again the same example --> asteroids = [10, -10]
                // For the above example, even after the list being empty, '-10' won't be added to the list.
                if((list.isEmpty() || list.get(list.size()-1)<0) && !blast)
                list.add(asteroids[i]);
            }
        }

        //Convert list to array
        int[] result=new int[list.size()];
        for(int i=0;i<list.size();i++)
        result[i]=list.get(i);

        return result;
    }
}