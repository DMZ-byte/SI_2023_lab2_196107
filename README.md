Filip, Domazetovski 196107

CONTROL FLOW GRAPH(CFG):

![SILab2CFG](https://github.com/DMZ-byte/SI_2023_lab2_196107/assets/65123022/c6eed7b1-7b5a-497a-8442-894975beb838)



 ЦИКЛОМАТСКА КОМПЛЕКСНОСТ:
 Цикломатската комплексност на програмата може да се пресмета користејќи или бројот на региони во CFG, или како сума од бројот на команди како (if, for, loop etc) плус еден. Има 4 if и 2 for команди, што значи дека цикломатската комплексност е 4+2+1=7.
 

 
Тест случаеви според критериумот Every Branch:       
| Test Case | user | user.getPassword() | user.getEmail() | Expected Output |
|-----------|------|-------------------|-----------------|-----------------|
| 1         | 0    | 0                 | 0               | 1               |
| 2         | 0    | 1                 | 1               | 1               |
| 3         | 1    | 0                 | 0               | 1               |
| 4         | 1    | 0                 | 1               | 1               |
| 5         | 1    | 1                 | 0               | 1               |
| 6         | 1    | 1                 | 1               | 0               |

Тест случаи според критериумот Every path: 

 | Test Case | user | user.getPassword() | user.getEmail() | user.getUsername() | allUsers |
|-----------|------|--------------------|-----------------|--------------------|----------|
| 1         | 0    | 0                  | 0               | -                  | -        |
| 2         | 0    | 0                  | 1               | -                  | -        |
| 3         | 0    | 1                  | 0               | -                  | -        |
| 4         | 0    | 1                  | 1               | -                  | -        |
| 5         | 1    | 0                  | 0               | -                  | -        |
| 6         | 1    | 0                  | 1               | -                  | -        |
| 7         | 1    | 1                  | 0               | -                  | -        |
| 8         | 1    | 1                  | 1               | -                  | -        |
| 9         | 1    | 1                  | 1               | -                  | [User1]  |
| 10        | 1    | 1                  | 1               | -                  | [User1, User2] |
| 11        | 1    | 1                  | 1               | null               | [User1]  |
| 12        | 1    | 1                  | 1               | null               | [User1, User2] |


## Објаснување :

# Every Branch
 За да обезбедиме тест случаи според критериумот Every Branch, треба секоја гранка на кодот е покриена со тест случај.

   задолжителни информации што недостасуваат /фрлање исклучок:
        В:  user = null, allUsers = [User1, User2]
        И: RuntimeException("Mandatory information missing!")

  Тест случај за поставување на корисничко име на епошта кога корисничкото име е нула:
        В: user = User(email="example@example.com"), allUsers = [User1, User2]
        И: user.getUsername() =  "example@example.com"
  Тест случај за постоечки корисник со иста епошта, но различно корисничко име:
        Влез: user = User(username="example", email="example@example.com"), allUsers = [User1(email="example@example.com", username="different")]
        Очекуван излез: same = 0

  Тест случај за постоечки корисник со иста епошта и корисничко име:
        Влез:  user = User(username="example", email="example@example.com"), allUsers = [User1(email="example@example.com", username="example")]
        Очекуван излез: same = 2

  Тест случај за лозинка која содржи корисничко име и должина помала од 8 :
        Влез: user = User(username="example", email="example@example.com", password="example"), allUsers = [User1]
        Очекуван излез: false

  Тест случај за лозинка што содржи специјален знак но без празно место:
        Внесување: user = User(username="example", email="example@example.com", password="example!123"), allUsers = [User1]
        Очекуван излез: false

  Тест случај за лозинка што содржи специјален знак и празно место:
        Внесување: user = User(username="example", email="example@example.com", password="example! 123"), allUsers = [User1]
        Очекуван излез: same = 0
        
   # Multiple Condition за условот „if (user==null || user.getPassword()==null || user.getEmail()==null)“:

  Сите услови ќе се вистинити:
    Input: user = null, user.getPassword() = null, user.getEmail() = null
    Expected Output: The condition evaluates to true

  user да биде null, но password и email да бидат 'nonnull':
    Input: user = null, user.getPassword() = "password", user.getEmail() = "example@example.com"
    Expected Output: The condition evaluates to true

  user да биде nonnull, но password и email да бидат null:
    Input: user = User(), user.getPassword() = null, user.getEmail() = null
    Expected Output: The condition evaluates to true

  user да биде 'nonnull', password да биде null, и email да биде nonnull:
    Input: user = User(), user.getPassword() = null, user.getEmail() = "example@example.com"
    Expected Output: The condition evaluates to true

 а user да биде nonnull, password да биде nonnull, и email да биде 'null':
    Input: user = User(), user.getPassword() = "password", user.getEmail() = null
    Expected Output: The condition evaluates to true

 Тест кај што сите услови се 'false':
    Input: user = User(), user.getPassword() = "password", user.getEmail() = "example@example.com" или
    Expected Output: The condition evaluates to false
        
