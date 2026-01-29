# Traffic Light Simulator

Segundo ejercicio del Laboratorio 2.

Este proyecto consiste en la simulación de un semáforo utilizando **Jetpack Compose** y **corrutinas**, donde las luces cambian automáticamente siguiendo la secuencia:

- Rojo
- Verde
- Amarillo

El estado del semáforo se maneja mediante **estado reactivo** y `LaunchedEffect`, permitiendo que la simulación funcione de forma continua.

---

## ✅ Definition of Done (DoD)

| Criterio | Descripción | Estado |
|--------|------------|--------|
| Enum definido | `enum class Light { Red, Yellow, Green }` existe | ✅ |
| Tres círculos | Apilado vertical de 3 `Box` con `CircleShape` | ✅ |
| Estados de color | Luz activa en color brillante, las demás en gris | ✅ |
| Ciclo automático | `LaunchedEffect` ejecuta un bucle infinito | ✅ |
| Tiempos correctos | Rojo: 2s → Verde: 2s → Amarillo: 1s → repetir | ✅ |
| Sin crashes | Manejo correcto del ciclo de vida (sin fugas) | ✅ |
| UI limpia | Semáforo centrado con espaciado adecuado | ✅ |

---
