# 선서합니다.
```
1. 본 작자는 절대, 사용자의 컴퓨터에 직접적으로 위협을 가할 수 있는 위험한 소스코드를 절대 공개하지 않을 것이며,  
본 저장소의 초심을 잃지 않도록 항상 노력할 것을 선서합니다.  
  
2. 프로그래밍의 목적은, 사용자를 더 편리하게 함이 목적임을 망각하지 않을 것이며,  
더 좋은 소스코드를 작성하도록 노력할 것을 선서합니다.  
  
3. 소스코드는 항상 발전가능성이 있음을 깨닫고,  
이미 작성한 소스코드라도, 더 발전시킬 수 있다면, 더 발전시킬 것을 선서합니다.
```
---
저장소 설명 
> 해당 저장소는 다양한 프로그래밍 언어에서 사용가능한 여러 도움이 될 package를 포함하고 있습니다.  
해당 저장소에 저장된 package들은 **[메인 사이트](https://hynrusang.github.io/)의 기록 보관소 중,  
Util package**에서 다운받으실 수 있습니다.  
해당 저장소에 사용된 언어들은 다음과 같습니다.
# <img src="c/C_Programming_Language.png" style="width: 20px; height: 20px"> C 
```해당 언어의 패키지는 Program Package 중, c package에서 다운받으실 수 있습니다.```
> ## DataStruct
>> `해당 패키지는 동적 자료구조를 쉽게 다룰 수 있는 c header 파일들이 들어있습니다.`
> ---
>> ### CustomType.h **[소스 보기](c/datastruct/CustomType.h)**  
>>> `해당 헤더파일은 같은 패키지의 다른 헤더파일에서 사용하는 데이터들을 다룹니다.`  
>> ---
>> #### typeSelector
>> ``` C
>> #define typeSelector
>> ```
>> 같은 패키지에 존재하는 다른 헤더파일의 **prints 함수**의 출력 형식을 지정합니다.  
>> 후의 **element**와 일치하는 형식을 지정하시기를 추천드립니다.  
>> #### element
>> ``` C
>> typedef {type} element;
>> ```
>> 같은 패키지에 존재하는 다른 헤더파일이 저장할 데이터의 타입을 지정합니다.  
> ---
>> ### Stack.h **[소스 보기](c/datastruct/Stack.h)**  
>>> `해당 헤더파일은 동적 Stack을 구현한 헤더파일입니다.`  
>> ---
>> #### Stack
>> ``` C
>> typedef struct stack Stack;  
>> ```
>> 하나의 데이터를 저장하는 역할을 합니다.  
>> #### StackHeader
>> ``` C
>> typedef struct stackheader StackHeader;
>> ```
>> Stack 구조체들을 저장하는 역할을 합니다.  
>> #### init()
>> ``` C
>> StackHeader* init();
>> ```
>> 동적으로 **StackHeader 구조체**를 초기화 시켜 줍니다.  
>> java에서의 객체 생성처럼 비슷하게, **StackHeader\* header = init();** 처럼 사용합니다.  
>> #### isEmpty(StackHeader*)
>> ``` C
>> int isEmpty(StackHeader* header);
>> ```
>> header가 비어있는지의 여부를 반환합니다.  
>> #### push(StackHeader*, element)
>> ``` C
>> void push(StackHeader* header, element data);
>> ```
>> header의 뒤에 data를 저장합니다.  
>> #### pop(StackHeader*)
>> ``` C
>> element pop(StackHeader* header);
>> ```
>> header의 마지막 값을 삭제하고, 해당 값을 반환합니다.  
>> #### peek(StackHeader*)
>> ``` C
>> element peek(StackHeader* header);
>> ```
>> header의 마지막 값을 반환합니다.  
>> **pop 함수**와는 다르게, 마지막 값을 삭제하지는 않습니다.  
>> #### prints(StackHeader*)
>> ``` C
>> void prints(StackHeader* header);
>> ```
>> header에 들어있는 요소를 모두 출력합니다.  
> ---
>> ### Queue.h **[소스 보기](c/datastruct/Queue.h)** 
>>> `해당 헤더파일은 동적 Queue을 구현한 헤더파일입니다.`  
>> ---
>> #### Queue
>> ``` C
>> typedef struct queue Queue;
>> ```
>> 하나의 데이터를 저장하는 역할을 합니다.  
>> #### QueueHeader
>> ``` C
>> typedef struct queueheader QueueHeader;
>> ```
>> Queue 구조체들을 저장하는 역할을 합니다.  
>> #### init()
>> ``` C
>> QueueHeader* init();
>> ```
>> 동적으로 QueueHeader 구조체를 초기화 시켜 줍니다.  
>> java에서의 객체 생성처럼 비슷하게, **QueueHeader\* header = init();** 처럼 사용합니다.  
>> #### isEmpty(QueueHeader*)
>> ``` C
>> int isEmpty(QueueHeader* header);
>> ```
>> header가 비어있는지의 여부를 반환합니다.  
>> #### put(QueueHeader* header, element data)
>> ``` C
>> void put(QueueHeader* header, element data);
>> ```
>> header의 뒤에 data를 저장합니다.  
>> #### get(QueueHeader*)
>> ``` C
>> element get(QueueHeader* header);
>> ```
>> header의 처음 값을 삭제하고, 해당 값을 반환합니다.  
>> #### peek(QueueHeader*)
>> ``` C
>> element peek(QueueHeader* header);
>> ```
>> header의 처음 값을 반환합니다.  
>> **get 함수**와는 다르게, 처음 값을 삭제하지는 않습니다.  
>> #### prints(QueueHeader*)
>> ``` C
>> void prints(QueueHeader* header);
>> ```
>> header에 들어있는 모든 요소를 출력합니다.  
> ---
>> ### Deque.h **[소스 보기](c/datastruct/Deque.h)** 
>>> `해당 헤더파일은 동적 Deque를 구현한 헤더파일입니다.`  
>> ---
>> #### Deque
>> ``` C
>> typedef struct deque Deque;
>> ```
>> 하나의 데이터를 저장하는 역할을 합니다.  
>> #### DequeHeader
>> ``` C
>> typedef struct dequeheader DequeHeader;
>> ```
>> Deque 구조체들을 저장하는 역할을 합니다.  
>> #### init()
>> ``` C
>> DequeHeader* init();
>> ```
>> 동적으로 DequeHeader 구조체를 초기화 시켜 줍니다.  
>> java에서의 객체 생성처럼 비슷하게, **DequeHeader\* header = init();** 처럼 사용합니다.  
>> #### isEmpty(DequeHeader*)
>> ``` C
>> int isEmpty(DequeHeader* header);
>> ```
>> header가 비어있는지의 여부를 반환합니다.  
>> #### inFront(DequeHeader*)
>> ``` C
>> void inFront(DequeHeader* header, element data);
>> ```
>> header의 앞에 data를 저장합니다.  
>> #### inBack(DequeHeader*)
>> ``` C
>> void inBack(DequeHeader* header, element data);
>> ```
>> header의 뒤에 data를 저장합니다.  
>> #### outFront(DequeHeader*)
>> ``` C
>> element outFront(DequeHeader* header);
>> ```
>> header의 처음 값을 삭제하고, 해당 값을 반환합니다.  
>> #### outBack(DequeHeader*)
>> ``` C
>> element outBack(DequeHeader* header);
>> ```
>> header의 마지막 값을 삭제하고, 해당 값을 반환합니다.  
>> #### peekFront(DequeHeader*)
>> ``` C
>> element peekFront(DequeHeader* header);
>> ```
>> header의 처음 값을 반환합니다.  
>> **outFront 함수**와는 다르게, 처음 값을 삭제하지는 않습니다.  
>> #### peekBack(DequeHeader*)
>> ``` C
>> element peekBack(DequeHeader* header);
>> ```
>> header의 마지막 값을 반환합니다.  
>> **outBack 함수**와는 다르게, 마지막 값을 삭제하지는 않습니다.  
>> #### prints(DequeHeader*)
>> ``` C
>> void prints(DequeHeader* header);
>> ```
>> header에 들어있는 요소를 모두 출력합니다.  
> ---
# <img src="java/Java_Programming_Language.png" style="width: 20px; height: 20px"> Java
```해당 언어의 패키지는 Program Package 중, java package에서 다운받으실 수 있습니다.```
> ## util
>> `해당 패키지는 java 프로그래밍에 도움이 되는 유용한 클래스들을 담고 있는 패키지입니다.`  
> ---
>> ### Database.java **[소스 보기](java/util/Database.java)**
>>> `해당 class 파일은 대부분의 객체를 담을 수 있고, 원하는 타입으로 다시 꺼낼 수 있는 class가 들어있습니다.`  
>> ---
>> #### public Database
>> ``` java
>> final public class Database;
>> ```
>> **파일의 메인 클래스입니다.**  
>> 해당 클래스는 거의 모든 타입의 객체를 담을 수 있고, 원하는 타입으로 다시 꺼낼 수 있는 가변 리스트를 구현한 클래스입니다.  
>> 해당 클래스가 equals 체크를 통해 중복되는 객체를 저장할지의 여부는, 생성자의 첫번째 인수를 통해 결정하실 수 있습니다.  
>> ##### 생성자
>> ``` java
>> public Database(boolean checkEquals);
>> public Database(boolean checkEquals, Object ...object);
>> ```
>> 생성자는 다음과 같습니다.  
>> ##### add(...Object)
>> ``` java
>> public void add(Object ...object);
>> ```
>> object들을 모두 객체의 내부 저장소에 push 합니다.  
>> **단, object 내에 null 값이 있으면, 해당 값은 내부 저장소에 추가되지 않습니다.**  
>> ##### public<T> T get(int, Class<T>)
>> ``` java
>> public<T> T get(int index, Class<T> type) throws IndexOutOfBoundsException, ClassCastException;
>> ```
>> 현재 저장되어 있는 객체들을 type 타입으로 다운캐스팅 하여 반환해줍니다.  
>> 단, type가 null이거나, index번째 객체가 type 타입으로 다운캐스팅 될 수 없으면, 에러를 반환합니다.  
>> 예시로, **Database.get(0, Integer.class)** 처럼 사용할 수 있으며,  
>> 이때도 0번째 객체가 Integer 타입으로 다운캐스팅 될 수 없으면. 에러를 반환합니다.  
>> ##### remove(int)
>> ``` java
>> public void remove(int index);
>> ```
>> index번째 객체를 삭제합니다.  
>> ##### isExist(int)
>> ``` java
>> public boolean isExist(int index);
>> ```
>> index번째 객체가 존재하는지의 여부를 반환합니다.  
>> 예시로, **for (int i = 0; Database.isExist(i); i++)** 처럼 사용할 수 있습니다.  
>> ##### getIndex(Object)
>> ``` java
>> public int getIndex(Object object);
>> ```
>> object가 위치한 인덱스를 반환합니다.  
>> 만약, object가 내부 저장소 내에 없다면, -1을 반환합니다.  
>> ##### length()
>> ``` java
>> public int length();
>> ```
>> 현재 저장되어 있는 객체의 수를 반환해줍니다.  
>> ##### toString()
>> ``` java
>> @Override public String toString();
>> ```
>> 현재 있는 모든 객체들의 toString이 반환하는 문자열들을 "\n"으로 묶은 문자열을 반환합니다.  
>> ##### equals(Object)
>> ```java
>> @Override public boolean equals(Object object);
>> ```
>> 현 객체와 object가 서로 타입, 가지고 있는 객체들이 모두 동일한지의 여부를 반환합니다.
> ---
>> ### file 패키지
>>> `해당 패키지는 java 상에서 file을 손 쉽게 다룰 수 있게 해 주는 class와 interface들이 들어있습니다.`  
>> ---
>>> #### Filepath.java **[소스 보기](java/util/file/Filepath.java)**
>>>> `해당 interface 파일은 내부 File 클래스들의 기본이 되는 class와 interface가 들어있습니다.`
>>> ---
>>> ##### FileDependency
>>> ```java
>>> class FileDependency;
>>> ```
>>> **다른 내부 File 관련 클래스들이 공통적으로 상속받게 될 클래스 입니다.**  
>>> 해당 클래스를 직접적으로 생성하거나, 외부에서 호출하는 것은 불가능합니다,  
>>> 반드시, 상속받게 될 다른 내부 File 관련 클래스들을 통해, 해당 클래스의 매서드를 호출하십시오.  
>>> ###### getPath()
>>> ```java
>>> public String getPath();
>>> ```
>>> 해당 File이 만들어 질 디렉토리를 반환합니다.  
>>> 만약, 현 디렉토리 내 만들어진다면, null을 반환합니다.
>>> ###### toString()
>>> ```java
>>> @Override public String toString();
>>> ```
>>> 해당 File의 소스코드를 반환합니다.
>>> ###### print()
>>> ```java
>>> public void print();
>>> ```
>>> ---
>>> ##### public Filepath
>>> ``` java
>>> public interface Filepath;
>>> ```
>>> **파일의 메인 interface입니다.**  
>>> 해당 인터페이스는 window 상에서 주요한 환경 변수를 담고 있는 인터페이스입니다.  
>>> 추가로 상속받을 필요 없이, Filepath.property처럼 호출할 수 있습니다.  
>>> ###### Local
>>> ```java
>>> public static String Local;
>>> ```
>>> window의 Local 폴더로 링크되는 환경 변수입니다.
>>> ###### Appdata
>>> ```java
>>> public static String Appdata;
>>> ```
>>> window의 Roaming 폴더로 링크되는 환경 변수입니다.
>>> ###### Onedrive
>>> ```java
>>> public static String Onedrive;
>>> ```
>>> window의 Onedrive로 링크되는 환경 변수입니다.
>>> ###### Programfiles
>>> ```java
>>> public static String Programfiles;
>>> ```
>>> window의 Program Files 폴더로 링크되는 환경 변수입니다.
>>> ###### Programfiles86
>>> ```java
>>> public static String Programfiles86;
>>> ```
>>> window의 Program Files (x86) 폴더로 링크되는 환경 변수입니다.
>>> ###### User
>>> ```java
>>> public static String User;
>>> ```
>>> 당신의 window 계정 폴더로 링크되는 환경 변수입니다.
>>> ###### Downloads
>>> ```java
>>> public static String Downloads;
>>> ```  
>>> Downloads 폴더로 링크되는 환경 변수입니다.  
>> ---
>>> #### Json.java **[소스 보기](java/util/file/Json.java)**
>>>> `해당 class 파일은 Json을 쉽게 다룰 수 있게 해 주는 class가 들어있습니다.`  
>>> ---
>>> ##### Json
>>> ``` java
>>> final public class Json;
>>> ```
>>> **파일의 메인 클래스입니다.**  
>>> java 내에서 .json 파일을 쉽게 다룰 수 있게 해주는 Json 클래스입니다.  
>>> 아직은 구현상의 한계로, json의 키에 또 다른 json을 할당하는 것은 불가능하지만,  
>>> 대신, 하나의 json key에 단일 데이터나, 여러 타입의 데이터들을 할당하는 것은 가능합니다.
>>> ###### keys()
>>> ```java
>>> public Database keys();
>>> ```
>>> 해당 json의 key들을 반환합니다.
>>> ###### values(key)
>>> ```java
>>> public Database values(String key);
>>> ```
>>> 해당 json의 key에 할당된 value들을 반환합니다.
>>> ###### add(String, ...Object)
>>> ```java
>>> public void add(String key, Object ...values);
>>> ```
>>> 해당 json의 key의 값에, 추가로 values의 요소들을 추가합니다.
>>> ###### replace(String, ...Object)
>>> ```java
>>> public void replace(String key, Object ...values);
>>> ```
>>> 해당 json의 key의 값을, values의 요소들로 대체합니다.
>>> ###### delete(String)
>>> ```java
>>> public void delete(String key);
>>> ```
>>> 해당 json의 key를 삭제합니다.
>> ---
