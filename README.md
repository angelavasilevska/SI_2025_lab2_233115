# SI_2025_lab2_233115
**Име и презиме:** Ангела Василевска  
**Број на индекс:** 233115  

---

## Control Flow Graph
![checkCart_CFG](https://github.com/user-attachments/assets/ca3b18b5-bf3b-4509-83cc-6b7ae0ddb27c)

---

## Цикломатска комплексност

Цикломатската комплексност на функцијата `checkCart` се пресметува со формулата:

**M = E - N + 2P**  
каде што:  
- **E** е број на рабови  
- **N** е број на јазли 
- **P** е бројот на поврзани компоненти 

### Од Control Flow Graph добиваме:
- **E = 23**
- **N = 19**
- **P = 1**

### Според тоа:
**M = 23 - 19 + 2*1 = 6**

-> Цикломатската комплексност на функцијата `checkCart` е **6**  
Ова значи дека се потребни најмалку **6 тест случаи** за целосно покривање на сите независни патеки низ кодот.

---

## Тест случаи според критериумот *Every Statement*

Критериумот бара секоја наредба да се изврши барем еднаш.

### Покриени услови:
- `if (allItems == null)`
- `if (item.name == null || item.name.length() == 0)`
- `if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)`
- `if (cardNumber != null && cardNumber.length() == 16)`
- `if (!Character.isDigit(c))`
- `if (item.getDiscount() > 0)`

### Тест случаи:
1. `allItems == null` ➝ се фрла `RuntimeException`
2. Item со `null` име ➝ се фрла `RuntimeException`
3. Item со цена > 300 ➝ се одзема 30 од сумата
4. Item со discount > 0 ➝ користи формула со попуст
5. Item со discount = 0 ➝ користи формула без попуст
6. Valid `cardNumber` (16 цифри)
7. Invalid `cardNumber` (буква во низата) ➝ `RuntimeException`

---

## Тест случаи според критериумот *Multiple Condition*

Целиме да ги покриеме сите логички комбинации од овој услов:

```java
if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)
```

### -> Според тоа ги добиваме следните комбинации за покривање кои најдобро може да ги визуелизираме преку табелата:

| Price > 300 | Discount > 0 | Quantity > 10 | Резултат |
| ----------- | ------------ | ------------- | -------- |
| false       | false        | false         | false    |
| true        | false        | false         | true     |
| false       | true         | false         | true     |
| false       | false        | true          | true     |


---

➡️ Напишани се 4 тест случаи кои ги покриваат сите комбинации на условот со логичка **OR**.

---

## Објаснување на напишаните unit тестови

Тестовите се напишани во класата `SILab2Test` и истите се поделени во две групи:

### `testEveryStatement()`

- Ја покрива **секоја наредба** во `checkCart`
- Користи комбинации од предмети со различни цени, попусти, количини и името на предметот
- Вклучува тест за:
  - `allItems == null` (фрла исклучок)
  - `item.name == null` (фрла исклучк)
  - Валиден предмет со и без попуст

### `testMultipleCondition()`

- Ја покрива логичката комбинација `price > 300 || discount > 0 || quantity > 10`
- Се прават 4 тест случаи со различни вредности за секој од трите услови

### Примери на assertion-и:
- `assertThrows(RuntimeException.class, ...)` — за тестови што очекуваат грешка
- `assertEquals(очекуванаСума, SILab2.checkCart(...))` — за проверка на точната пресметка



