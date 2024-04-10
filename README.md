# [Principios S.O.L.I.D.]

**Proyecto archivado.** Nueva localización en [apuntes-general](https://github.com/alxgcrz/apuntes-general).

----

SOLID es el acrónimo que acuñó **Michael Feathers**, basándose en los principios de la programación orientada a objetos que **Robert C. Martin** había recopilado en el año 2000 en su paper ["_Design Principles and Design Patterns_"](http://www.cvc.uab.es/shared/teach/a21291/temes/object_oriented_design/materials_adicionals/principles_and_patterns.pdf).

Ocho años más tarde, el _tío Bob_ siguió compendiando consejos y buenas prácticas de desarrollo y se convirtió en el padre del código limpio con su célebre libro _'Clean Code'_.

Entre los objetivos de tener en cuenta estos 5 principios a la hora de escribir código encontramos:

- Crear un **software eficaz**: que cumpla con su cometido y que sea **robusto y estable**.
- Escribir un **código limpio y flexible** ante los cambios: que se pueda modificar fácilmente según necesidad, que sea **reutilizable y mantenible**.
- Permitir **escalabilidad**: que acepte ser ampliado con nuevas funcionalidades de manera ágil.

En  este sentido la aplicación de los principios SOLID está muy relacionada con la comprensión y el uso de **patrones de diseño**, que nos permitirán mantener una **alta cohesión** y, por tanto, un **bajo acoplamiento** de software. En definitiva, desarrollar un software de calidad.

El acoplamiento se refiere al **grado de interdependencia que tienen dos unidades de software entre sí**, entendiendo por unidades de software: clases, subtipos, métodos, módulos, funciones, bibliotecas, etc.

Si dos unidades de software son completamente independientes la una de la otra, decimos que están desacopladas.

La cohesión de software es el **grado en que elementos diferentes de un sistema permanecen unidos para alcanzar un mejor resultado** que si trabajaran por separado. Se refiere a la forma en que podemos agrupar diversas unidades de software para crear una unidad mayor.

Los principios SOLID son eso: principios, es decir, **buenas prácticas** que pueden ayudar a escribir un mejor código: más limpio, mantenible y escalable.

Como indica el propio Robert C. Martin en su artículo “_Getting a SOLID start_” no se trata de reglas, ni leyes, ni verdades absolutas, sino más bien soluciones de sentido común a problemas comunes. Son heurísticos, basados en la experiencia: “se ha observado que funcionan en muchos casos; pero no hay pruebas de que siempre funcionen, ni de que siempre se deban seguir.”

Dice el _tío Bob_, que SOLID nos ayuda a categorizar lo que es un buen o mal código y es innegable que un código limpio tenderá más a salir airoso del “control de calidad de código” WTFs/Minute. Consejo: cuando estés revisando un código, lleva la cuenta de cuántas veces por minuto sale de tu boca un WTF?.

![WTFs/Minute](https://profile.es/pro/wp-content/media/code-quality-measurement-WTF.png)

Los 5 principios SOLID son:

- [**S - Principio de Responsabilidad Única** ("_Single Responsibility Principle_" - SRP)](https://es.wikipedia.org/wiki/Principio_de_responsabilidad_%C3%BAnica)

Este principio establece que cada módulo o clase debe tener **responsabilidad sobre una sola parte de la funcionalidad** proporcionada por el software y esta responsabilidad debe estar encapsulada en su totalidad por la clase. Todos sus servicios deben estar estrechamente alineados con esa responsabilidad.

- [**O - Principio de Abierto/Cerrado** ("Open/Closed Principle" - OCP)](https://es.wikipedia.org/wiki/Principio_de_abierto/cerrado)

Este principio establece que **«una entidad de software (clase, módulo, función, etc.) debe quedar abierta para su extensión, pero cerrada para su modificación»**. Es decir, se debe poder extender el comportamiento de la entidad pero sin modificar su código fuente.

- [**L - Principio de Substitución de Liskov** ("Liskov Substitution Principle" - LSP)](https://es.wikipedia.org/wiki/Principio_de_sustituci%C3%B3n_de_Liskov)

Este principo puede definirse como: **«cada clase que hereda de otra puede usarse como su padre sin necesidad de conocer las diferencias entre ellas»**.

- [**I - Principio de Segregación de la Interfaz** ("Interface Segregation Principle" - ISP)](https://es.wikipedia.org/wiki/Principio_de_segregaci%C3%B3n_de_la_interfaz)

Este principio establece que los clientes de un programa dado sólo deberían conocer **aquellos métodos del programa que realmente usan, y no aquellos que no necesitan usar**.

- [**D - Principio de Inversión de Dependencias** ("Dependency Inversion Principle" - DIP)](https://es.wikipedia.org/wiki/Inyecci%C3%B3n_de_dependencias)

Este principio consta de dos partes:

  1. **Módulos de alto nivel no deben depender de módulos de bajo nivel**. Ambos deben depender de abstracciones.

  2. **Abstracciones no deberían depender de detalles**. Los detalles debieran depender de abstracciones.

## _"Single Responsibility Principle"_

![SRP](https://raw.githubusercontent.com/alxgcrz/apuntes-principios-solid/master/images/single_responsibility_principle_thumb.jpg)

> _"A class should have one, and only one, reason to change"_  
> -- Robert C. Martin

Este principio ayuda a crear código de calidad, mantenible, reusable, testeable, fácil de implementar y previene de efectos secundarios en los cambios. Es aplicable a clases, componentes de software o microservicios.

Los requerimientos del código pueden cambiar con el tiempo. Cada uno de estos cambios en los requerimientos modifica al menos la responsabilidad de una clase. Si una clase tiene muchas responsabilidades deberá cambiar más a menudo que si sólo tuviera una responsabilidad. Estos cambios tan reiterados pueden introducir errores o efectos secundarios en otras partes del código. Por tanto, **una clase sólo debería cambiar por una única razón** o lo que es lo mismo, que cambie la responsabilidad de la que se ocupa. Es esto, precisamente, "_razón para cambiar"_, lo que Robert C. Martin identifica como "responsabilidad".

Las clases con una única responsabilidad son más fáciles de mantener y más fáciles de explicar.

### Implementación

En el siguiente ejemplo tenemos la clase `Vehicle` que modela un vehículo y sus propiedades y que además tiene la responsabilidad de repostar el vehículo. Por tanto si cambia el modelo `Vehicle` o si cambia la forma de repostar combustible esta clase tendrá dos motivos para cambiar. Esta clase no cumple el *__"Single Responsibility Principle"__*:

```java
class Vehicle {
    private final int maxFuel;
    private int remainingFuel;

    public Vehicle(final int maxFuel) {
        this.maxFuel = maxFuel;
        remainingFuel = maxFuel;
    }

    // Esto no es responsabilidad de la clase 'Vehicle'
    public void reFuel() {
        remainingFuel = maxFuel;
    }

    public int getMaxFuel() {
        return maxFuel;
    }

    public int getRemainingFuel() {
        return remainingFuel;
    }

    // ....
}
```

Para aplicar el *__"Single Responsibility Principle"__* deberemos refactorizar la clase `Vehicle` y crear una clase como por ejemplo `FuelPump` cuya responsabilidad sea el repostaje de combustible del vehículo, eliminando este método de la clase `Vehicle`:

![Diagram](https://raw.githubusercontent.com/alxgcrz/apuntes-principios-solid/master/src/solid/srp/srp_solution_diagram.png)

Quedando la nueva clase de esta forma:

```java
class FuelPump {
    void reFuel(final Vehicle vehicle) {
        final int remainingFuel = vehicle.getRemainingFuel();
        final int additionalFuel = vehicle.getMaxFuel() - remainingFuel;
        vehicle.setRemainingFuel(remainingFuel + additionalFuel);
    }
}
```

## _"Open/Closed Principle"_

![OCP](https://raw.githubusercontent.com/alxgcrz/apuntes-principios-solid/master/images/openclosed_principle_thumb.jpg)

> _"Software entities (classes, modules, functions, etc...) should be open for extension, but closed for modification"_  
> -- Robert C. Martin

La idea es escribir código de forma que sea posible añadir nuevas funcionalidades pero sin modificar el código existente. Esto previene situaciones en que al modificar clases base nos veamos obligados también a adaptar todas las clases dependientes.

Inicialmente este principio se basaba en el uso de la herencia pero **Robert C. Martin** y otros autores con el tiempo y la experiencia llegaron a la conclusión que la herencia crea una fuerte dependencia entre las clases. Es recomendable el uso de **interfaces** en lugar de la herencia.

El mayor beneficio es que las interfaces introducen una capa extra de abstracción que otorga un bajo nivel de acoplamiento. Las implementaciones que hace cada clase de esa interfaz son independientes unas de otras y no necesitan compartir el código.

En el caso de que los beneficios de compartir código fueran notables sería mejor optar por la herencia o la composición.

### Implementación

En el siguiente ejemplo tenemos la clase `EventHandler` con el método `changeDrivingMode()` que permite cambiar ciertos parámetros de la clase `Vehicle` según el modo de conducción. Este modo de conducción se codifica en una enumeración:

```java
class EventHandler {

    enum DrivingMode {
        SPORT, COMFORT
    }

    private Vehicle vehicle;

    public EventHandler(final Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    void changeDrivingMode(final DrivingMode drivingMode) {
        switch (drivingMode) {
            case SPORT:
                vehicle.setPower(500);
                vehicle.setSuspensionHeight(10);
                break;
            case COMFORT:
                vehicle.setPower(400);
                vehicle.setSuspensionHeight(20);
                break;
            default:
                vehicle.setPower(200);
                vehicle.setSuspensionHeight(30);
                break;
            // Cuando necesitemos añadir otro modo (e.g. ECONOMY) deberemos cambiar la clase 'EventHandler' y la enumeración 'DrivingMode'.
        }
    }
}
```

```java
class Vehicle {
    private int power;
    private int suspensionHeight;

    int getPower() {
        return power;
    }

    void setPower(final int power) {
        this.power = power;
    }

    int getSuspensionHeight() {
        return suspensionHeight;
    }

    void setSuspensionHeight(final int suspensionHeight) {
        this.suspensionHeight = suspensionHeight;
    }
}
```

El *__"Open/Closed Principle"__* se incumple ya que si tenemos que añadir un nuevo modo de conducción, deberemos añadir el nuevo modo en la enumeración y además deberemos modificar el método `changeDrivingMode(DrivingMode drivingMode)` para tener en cuenta este nuevo modo.

Para cumplir el *__"Open/Closed Principle"__* deberemos refactorizar el código de forma que el método `changeDrivingMode(DrivingMode drivingMode)` no necesite ser modificado si se añade nueva funcionalidad o nuevos modos de conducción. Por tanto debe permanecer cerrado a la modificación.

Esto lo podemos conseguir haciendo uso de las **interfaces** (en vez del uso de la herencia) de modo que en el método `changeDrivingMode(DrivingMode drivingMode)` utilicemos la interfaz `DrivingMode`. Las clases que modelan los modos de conducción implementarán dicha interfaz. Si en el futuro necesitamos añadir un nuevo modo de conducción únicamente será necesario añadir la nueva clase que implemente la interfaz `DrivingMode` para que el sistema tenga en cuenta el nuevo modo. El método `changeDrivingMode(DrivingMode drivingMode)` permanecerá inalterado y plenamente funcional ya que este método hace uso de la interfaz y ésta no se ha modificado.

![Diagram](https://raw.githubusercontent.com/alxgcrz/apuntes-principios-solid/master/src/solid/ocp/ocp_solution_diagram.png)

```java
interface DrivingMode {
    int getPower();
    int getSuspensionHeight();
}

class Comfort implements DrivingMode {
    private static final int POWER = 400;
    private static final int SUSPENSION_HEIGHT = 20;

    @Override
    public int getPower() {
        return POWER;
    }

    @Override
    public int getSuspensionHeight() {
        return SUSPENSION_HEIGHT;
    }
}

class Sport implements DrivingMode {
    private static final int POWER = 500;
    private static final int SUSPENSION_HEIGHT = 10;

    @Override
    public int getPower() {
        return POWER;
    }

    @Override
    public int getSuspensionHeight() {
        return SUSPENSION_HEIGHT;
    }
}
```

```java
class EventHandler {
    private Vehicle vehicle;

    public EventHandler(final Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void changeDrivingMode(final DrivingMode drivingMode) {
        vehicle.setPower(drivingMode.getPower());
        vehicle.setSuspensionHeight(drivingMode.getSuspensionHeight());
        // Ahora, cuando necesitemos añadir otro modo (e.g. ECONOMY) sólo hay que crear la clase 'Economy'.
    }
}
```

## _"Liskov Substitution Principle"_

![LSP](https://raw.githubusercontent.com/alxgcrz/apuntes-principios-solid/master/images/liskov_substitution_principle_thumb.jpg)

El *__"Liskov Substitution Principle"__* extiende el *__"Open/Closed Principle"__* pero focalizado en el comportamiento de una superclase y sus subtipos.

Este principio define que los objetos de una superclase deben ser reemplazables por objetos de sus subclases sin "romper" la aplicación o sistema y sin efectos secundarios. Eso requiere que los objetos de las subclases se comporten de la misma manera que los objetos de la superclase de forma que se puedan usar de forma indistinta.

Para conseguir esto las subclases deberían seguir estas reglas:

- No implementar reglas de validación más estrictas en los parámetros de entrada que las implementadas por la clase base.
- Aplicar al menos las mismas reglas a todos los parámetros de salida aplicados por la clase base.

