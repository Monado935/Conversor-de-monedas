# Conversor de Monedas en Java

Este proyecto es un **conversor de monedas** desarrollado en **Java** que permite transformar montos entre distintas divisas.  
Está pensado como una herramienta sencilla para practicar programación orientada a objetos, manejo de tipos numéricos y, opcionalmente, consumo de APIs externas de tasas de cambio (si decides integrarlas).

---

## Características

- Conversión entre múltiples divisas.
- Manejo de código de moneda (por ejemplo, `USD`, `EUR`, `MXN`).
- Validación básica de entradas (monto y código de moneda).
- Arquitectura sencilla y fácil de extender (puedes agregar más monedas o fuentes de tasas de cambio).
- Implementado completamente en Java.

---

## Divisas soportadas

El conversor soporta actualmente las siguientes monedas:

| Código | Moneda               |
|--------|----------------------|
| CHF    | Franco Suizo         |
| EUR    | Euro                 |
| COP    | Peso Colombiano      |
| USD    | Dólar Estadounidense |
| ARS    | Peso Argentino       |
| CLP    | Peso Chileno         |
| GBP    | Libra Esterlina      |
| JPY    | Yen Japonés          |
| CNY    | Yuan Chino           |
| MXN    | Peso Mexicano        |
| BRL    | Real Brasileño       |
| PEN    | Sol Peruano          |
| CAD    | Dólar Canadiense     |
| AUD    | Dólar Australiano    |

## Requisitos

- **Java** 8+ (recomendado Java 11 o superior).
- (Opcional) **Maven** o **Gradle** 
- Un IDE o editor de texto de tu preferencia: IntelliJ IDEA, Eclipse, VS Code, NetBeans, etc.

---
