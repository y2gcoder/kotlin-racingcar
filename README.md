# kotlin-racingcar

## stpe 3 - 자동차 경주
### 기능 요구 사항
- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [x] 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [x] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 프로그래밍 요구사항
- [x] 모든 로직에 단위 테스트를 구현(UI 제외)
- [x] UI 로직: InputView, ResultView

### 추가 피드백
- [ ] Car의 position 값을 외부에서 변경하지 못하도록 하기
- [ ] car.move() 를 선택한 이유 설명하기
- [ ] functional interface vs 단순 함수형 선언 차이 체크 및 선택
- [ ] kotlin list 생성 방법 숙지
- [ ] RacingGame 생성 시 carCount 를 바로 받지 않고 ValueClass로 받도록 해보기
- [ ] RacingGameTest 에서 무조건 전진하는 함수를 따로 변수로 명확하게 표현하기(alwaysMove)