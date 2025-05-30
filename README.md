# ⚔️ Batalla de Poderes

> **Parcial final de la materia Estructuras de Datos**  
Juego de cartas por rondas, implementado en Java con estructuras como lista enlazada, cola, pila y árbol binario de decisión.

---

## 🧠 Descripción

"Batalla de Poderes" es un juego de cartas por rondas en el que un jugador humano se enfrenta a una CPU. Ambos seleccionan cartas con distintos poderes y elementos (Fuego, Agua, Tierra, Aire) y luchan durante 5 rondas. El jugador con más rondas ganadas al final será el vencedor.

Este proyecto está completamente desarrollado en **Java**, aplicando estructuras de datos implementadas desde cero:

- Lista Enlazada (baraja inicial)
- Cola (mazo del jugador y CPU)
- Pila (cementerio de derrotados)
- Árbol binario de decisión (lógica de la CPU)
- Tabla Hash (registro de estadísticas)

---

## 🚀 Cómo iniciar el proyecto

### ✅ Requisitos previos

- Java JDK 17 o superior
- Un entorno de desarrollo como IntelliJ IDEA, Eclipse o VS Code con soporte para Java

### ▶️ Instrucciones

1. **Clona el repositorio o descarga el código fuente**:
    ```bash
    git clone https://github.com/SebasDev807/BatallaDePoderes.git
    ```

2. **Abre el proyecto en tu IDE favorito**

3. Asegúrate de que el **JDK esté correctamente configurado** en el proyecto (preferiblemente Java 17).

4. Navega a la clase `org.juego.Juego` y ejecuta el método `iniciar()` desde el `main` o puedes crear uno así:

    ```java
    public class Main {
        public static void main(String[] args) {
            new Juego().iniciar();
        }
    }
    ```

5. Corre el proyecto. ¡Listo para jugar! 🎮

---

## 👥 Integrantes

- Juan Sebastián Astudillo Ordoñez
- Dhayana Valentina Muñoz Fernandez
- Tulio Herney Martinez Lasso
- David Cabrera
- Edwin Constain
---

> ℹ️ **Nota:** Esta versión (`v1.0.0-rc.1`) corresponde a una implementación preliminar basada en los requerimientos propuestos en clase.  
> Puede ser adaptada o extendida según los criterios específicos de cada ejercicio o evaluación.

