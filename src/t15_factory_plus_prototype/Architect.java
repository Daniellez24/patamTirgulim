package t15_factory_plus_prototype;

public class Architect extends Employee{
    // prototype solution:
    @Override
    public Employee cloneMe() {
        return new Architect();
    }
}
