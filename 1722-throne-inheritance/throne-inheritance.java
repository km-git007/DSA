
class ThroneInheritance {

    private class Person{

        String name;
        String parent;
        boolean isAlive;
        List<Person> children;

        public Person(String name, String parent) {
            this.name = name;
            this.isAlive = true;
            this.parent = parent;
            children=new ArrayList<>();
        }
    }

    private HashMap<String,Person> personMap;
    private Person king;

    private void preorderInheritanceOrder(Person person,List<String> inheritanceList)
    {
        if(person==null)
        return;

        if(person.isAlive)
        inheritanceList.add(person.name);

        List<Person> childrenList=person.children;
        for(Person child : childrenList)
        preorderInheritanceOrder(child,inheritanceList);
    }

    public ThroneInheritance(String kingName)
    {
        Person person=new Person(kingName,null);
        king=person;
        personMap=new HashMap<>();
        personMap.put(kingName,king);
    }

    public void birth(String parentName, String childName)
    {
        Person person=new Person(childName,parentName);
        Person parent=personMap.get(parentName);
        parent.children.add(person);

        personMap.put(childName,person);
    }

    public void death(String name)
    {
        Person person=personMap.get(name);
        person.isAlive=false;
    }

    public List<String> getInheritanceOrder()
    {
        List<String> inheritanceList=new ArrayList<>();
        preorderInheritanceOrder(king,inheritanceList);
        return inheritanceList;
    }
}


/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */