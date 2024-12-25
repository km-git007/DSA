/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) 
    {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee employee : employees)
        map.put(employee.id, employee);

        int imp = 0;
        Queue<Employee> q = new LinkedList<>();
        q.add(map.get(id));
        while(!q.isEmpty())
        {
            Employee emp = q.poll();
            imp += emp.importance;

            for(int subOrdinateId : emp.subordinates)
            q.add(map.get(subOrdinateId));
        }
        return imp;
    }
}