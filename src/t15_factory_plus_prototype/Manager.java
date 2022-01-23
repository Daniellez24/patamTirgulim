package t15_factory_plus_prototype;

public class Manager extends Employee{
    // prototype solution:
    @Override
    public Employee cloneMe() {
        return new Manager();
    }
}
