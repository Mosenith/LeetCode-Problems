package DesignPattern.FactoryPattern;

// Abstract Class Computer is a super class
// Subclasses: PC & Server will extend this super class
// and override abstract methods
public abstract class Computer {
    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

    @Override
    public String toString(){
        return "RAM=" + this.getRAM() + ", HDD=" + this.getHDD()
                + ", CPU=" + this.getCPU();
    }
}
