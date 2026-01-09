import java.util.ArrayList;
import java.util.List;

abstract class Animal {

    private String nombre;

    private Integer alturaEnCm;

    private Double pesoKg;

    private String raza;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAlturaEnCm() {
        return alturaEnCm;
    }

    public void setAlturaEnCm(Integer alturaEnCm) {
        this.alturaEnCm = alturaEnCm;
    }

    public Double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(Double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String toString() {
        return "Nombre: " + nombre + " ,raza: " + raza;
    }

    public abstract void sonido();
}

class Gato extends Animal implements ComeCarne{

    private int vidasRestantes;

    public Gato(String carneFavorita, int vidasRestantes) {
        this.carneFavorita = carneFavorita;
        this.vidasRestantes = vidasRestantes;
    }

    private String carneFavorita;

    public int getVidasRestantes() {
        return vidasRestantes;
    }

    public void setVidasRestantes(int vidasRestantes) {
        this.vidasRestantes = vidasRestantes;
    }

    @Override
    public void sonido() {
        System.out.println("Miauuuuu");
    }

    @Override
    public String dimeTuCarneFavorita() {
        return carneFavorita;
    }
}

class Callejero extends Gato {

    // Constructor obligatorio porque Gato lo define así
    public Callejero(String carneFavorita, int vidasRestantes) {
        super(carneFavorita, vidasRestantes);
    }

    @Override
    public void sonido() {
        // Provocaría un StackOverflowError
        //this.sonido();
        // Llama a sonido del padre
        //super.sonido();
        System.out.println("meow");
    }

    @Override
    public int getVidasRestantes() {
        return super.getVidasRestantes() / 2;
    }
}


class Perro extends Animal implements ComeCarne{

    @Override
    public void sonido() {
        System.out.println("Guau guau");
    }

    @Override
    public String dimeTuCarneFavorita() {
        return "Pollo";
    }
}


class Labrador extends Perro {

}

class Mestizo extends Perro {
    @Override
    public void sonido() {
        System.out.println("guau");
    }
}


class Gorila extends Animal {
    @Override
    public void sonido() {
        System.out.println("boom");
    }
}


class Leon extends Animal implements ComeCarne {
    @Override
    public void sonido() {
        System.out.println("GRRRR");
    }

    @Override
    public String dimeTuCarneFavorita() {
        return "Cebra";
    }
}

interface ComeCarne {
    // Método que deben implementar todos los que ComeCarne
    String dimeTuCarneFavorita();

    default String dimeTuAnimalFavorito() {
        return "Mono";
    }
}

class Main {
    public static void main(String[] args) {

        // Crea una variable de tipo Animal y la inicializa como un Perro
        Animal manolo = new Labrador();
        manolo.setNombre("Manolo");
        manolo.setAlturaEnCm(120);
        manolo.setPesoKg(8.5);
        manolo.setRaza("Perro");

        Animal sally = new Mestizo();
        sally.setNombre("Sally");
        sally.setAlturaEnCm(120);
        sally.setPesoKg(8.5);
        sally.setRaza("Perro");


        // Crea una variable de tipo Animal y la inicializa como un Gato
        Animal molly = new Callejero("Zanahoria", 5);
        molly.setNombre("Molly");
        molly.setAlturaEnCm(75);
        molly.setPesoKg(12.2);
        molly.setRaza("Callejero");

        Animal cali = new Callejero("Perscado", 7);
        cali.setNombre("cali");
        cali.setAlturaEnCm(75);
        cali.setPesoKg(12.2);

        Animal koko = new Gorila();
        koko.setNombre("Koko");
        koko.setAlturaEnCm(180);
        koko.setPesoKg(150.5);
        koko.setRaza("Gorila");




        // Crea una lista de Animal(abstracta)
        List<Animal> animals = new ArrayList<>();
        animals.add(manolo);
        animals.add(molly);
        animals.add(sally);
        animals.add(koko);
        animals.add(cali);


        // List<Animal> animals;

        // Pinta el nombre de todos los animales - usando streams
        animals.stream().forEach(animal -> System.out.println(animal.getNombre()));


        // Pinta el nombre de todos los animales - usando for con indice
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).getNombre());
        }

        // Pinta el nombre de todos los animales - usando for-each
        for (Animal animal : animals) {
            System.out.println(animal.getNombre());
        }

        // Emite sonidos
        animals.stream().forEach(animal -> animal.sonido());

        // Pintar vidas restantes si es un gato
        for (Animal animal : animals) {

            // Comprueba si es de tipo gato
            if (animal instanceof Gato) {
                // Hace un "Cast" a tipo gato
                Gato gato = (Gato) animal;
                System.out.println(gato.getVidasRestantes());
            }
        }

        // Controlando la excepcion
        for (Animal animal : animals) {
            // Hace un "Cast" a tipo gato
            try {
                Gato gato = (Gato) animal;
                System.out.println(gato.getVidasRestantes());
            } catch (ClassCastException e) {
                System.out.println("El animal no se puede ser Gato");
            }
        }

        for (Animal animal : animals) {
            // Comprueba si implementa interface ComeCarne
            if (animal instanceof ComeCarne) {
                ComeCarne animalComeCarne = (ComeCarne) animal;
                System.out.println(animal.getNombre());
                System.out.println(animalComeCarne.dimeTuCarneFavorita());
            }
        }

    }
}