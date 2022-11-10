# TDD-Study
Junit 및 TDD 공부
# 공부배경 - 2022/11/07
나는 개발 공부를 하며 여러 API 또는 로직을 만드는데 있어 검증을 직접 서버를 돌려서 포스트맨을 통해 진행하거나 테스트 코드를 정말 간단하게 구성하여 print를 하여 확인했다. 이러한 과정이 반복되니 검증에 대한 속도도 느렸다. 또한 일정한 테스트 주기가 없이 내가 어느정도 기능이 완성되었다고 생각할 때 테스트를 진행해 내가 작성한 코드가 중구난방이라는 것을 느꼈다. 그래서 이번에 테스트코드와 테스트 주도 개발에 대해 공부를 해보려한다.
# TDD 시작
### TDD(Test Driven Development)?
테스트 주도 개발이란 테스트코드를 먼저 작성하고 해당 테스트를 통과하는 코드를 구현하는 개발법을 뜻한다.
TDD는 테스트를 먼저 작성하고 테스트에 실패하면 테스트를 통과시킬 만큼의 코드를 구현하고 리팩토링을 진행한다. 이러한 과정을 반복하면서 점진적으로 기능을 완성해 나간다. 
이름 그대로 테스트가 주도하는 개발인 것이다.

### TDD의 흐름
![image](https://user-images.githubusercontent.com/97887047/200323677-8742ab7c-ae75-4c4f-adf6-41b015048516.png)

TDD는 위의 흐름을 따른다. 여기서 테스트 코드 작성을 빨간색으로 나타낸이유는 테스트코드가 실패하면 빨간색으로 표시되기 때문이다. 즉, 실패하는 테스트 코드를 작성한다는 것이다. 그리고 구현은 초록색으로 나타내어 있는데 이는 통과하는 코드를 작성한다는 것이다. 여기서 중요한 것이 있는데 **작성한 테스트를 통과할 만큼의 코딩만 해야한다는 것이다.** 위의 과정을 점진적으로 반복하면서 기능을 완성한다.

### TDD의 장점 - 지속적인 코드 정리
구현을 완료한 뒤에 리팩토링을 하는 것은 굉장히 복잡하다. 구현된 코드도 많을 것이고 하나를 건들다보면 다른 것에서 오류가 날 수도 있다. 하지만 TDD에서는 지속적으로 리팩토링을 진행하는데 이 때 진행하는 리팩토링의 코드량이 적어 리팩토링을 하기에 수월하고 이미 테스트를 통과한 코드를 리팩토링한다는 점에서 심리적인 불안감을 덜어줄 수 있다. 

# 테스트 코드 작성 순서
TDD에서 테스트 코드를 작성할 때는 아래의 규칙을 따르는 것이 좋다.
#### 쉬운 경우에서 어려운 경우로 진행
#### 예외적인 경우에서 정상인 경우로 진행

시작부터 복잡한 테스트로 시작하게 된다면 다양한 상황을 생각하면서 구현해야할 코드의 양이 많아진다.
따라서 구현하기 쉬운 테스트부터 시작하는 것이 좋다. 

### 예외 상황을 먼저 테스트해야한다.
예외 상황을 처리할 때는 if-else문을 사용하는 경우가 많다. 예외 상황을 반영하지 않은 코드에 예외 상황을 반영하려면 코드의 구조가 뒤집히고 다른 조건문을 추가해야하는 등 코드를 더욱 복잡하게 만들 가능성이 있다. 예외 상황을 찾아 테스트하고 먼저 구현한다면 이러한 경우를 줄일 수 있다.

# Junit5
자바용 유닛 테스트 프레임워크이다. Junit4부터는 어노테이션으로 간결하게 지원한다. Junit5는 테스트를 위한 API로 주피터 API를 제공한다. 

## Junit 어노테이션 정리
### @Test
테스트를 하고자하는 메서드에 붙이면 해당 메서드는 테스트 메서드로 동작한다.
### @SpringBootTest
실제 애플리케이션을 자신의 로컬 위해 올리고 포트번호가 주어지고 실제 DB와 커넥션이 붙어있는 상태에서 테스트가 진행되게 된다. 따라서 애플리케이션 규모에 따라 시간이 오래 걸릴 수도 있다.
### @WebMvcTest
컨트롤러 테스트 어노테이션이다. 웹의 요청 응답 테스트에 필요한 빈을 가져온다.
### @ExtendWith
확장을 선언적으로 등록할 때 사용한다.
### @BeforeAll
테스트가 실행될 때 가장 처음으로 실행된다.
### @BeforeEach
각 테스트 메서드가 실행될 때마다 실행된다.
### @AfterAll
모든 테스트가 끝나고 실행된다.
### @AfterEach
각 테스트 메서드가 끝날때마다 실행된다.
### @Disabled
해당 어노테이션이 붙은 메서드는 실행에서 빠진다.
### @DisplayName
테스트 이름을 지정해줄 수 있다.

## 주요 단언 메서드
Assertions(jupiter) 클래스는 여러 단언 메서드를 제공한다. 이를 통해 결과를 검증할 수 있다.
### assertEquals(기댓값, 실제값)
실제값이 기댓값과 같은지 검사한다.
### assertNotEquals(기댓값, 실제값)
실제값이 기댓값과 같지않은지 검사한다.
### assertSame(기대객체, 실제객체)
두 객체가 동일한 객체인지 검사한다.
### assertNotSame(기대객체, 실제객체)
두 객체가 동일하지 않은 객체인지 검사한다.
### assertTrue(boolean condition)
값이 true인지 검사한다.
### assertFalse(boolean condition)
값이 false인지 검사한다.
### assertNull(Object)
값이 null인지 검사한다.
### assertNotNull(Object)
값이 null이 아닌지 검사한다.
### assertThrows(Class<T> expectedType, Executable executable)
실행한 결과로 지정한 타입의 익셉션이 발생하는지 검사한다.

# 대역
테스트를 작성하다보면 외부요인(DB, 외부API 등)이 필요한 경우가 있는데 외부 요인이 테스트에 관여하게 된다면 테스트를 바로 진행하지 못할 수도있다. 가령, 외부 API를 사용하고 있는데 API 점검 때문에 테스틀 시도하지 못하는 경우같은게 있다. 

그러면 이 때 사용하는 방법이 대역을 사용하는 것이다. 대역이란 해당되는 기능을 흉내내는 것이다. DB같은 경우에는 In memory DB로 대체하거나 외부 API는 단순한 클래스를 만들어 비슷하게 응답해주는 기능을 만들어 대체하는 것이다.

## 대역의 종류
### 스텁(Stub)
구현을 단순한 것으로 대체한다. 스텁은 테스트에 맞게 단순히 원하는 동작을 수행하는 것이다.
### 가짜(Fake)
제품에는 적합하지 않지만, 실제 동작하는 구현을 제공한다. DB 대신 In MemoryDB를 사용하는 경우
### 스파이(Spy)
호출된 내역을 기록한다. 기록한 내용을 테스트 결과를 검증할 때 사용한다.
### 모의(Mock)
가짜 객체를 만들어 사용하는 방법, 즉 가짜 객체를 의미한다. Mock 객체는 스텁이자 스파이도 된다.

### Mockito
#### Mokito란?모의 객체 생성, 검증, 스텁을 지원하는 프레임워크이다.
