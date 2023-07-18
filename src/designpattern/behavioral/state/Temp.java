package designpattern.behavioral.state;

/**
 * <p>
 * 상태 패턴은 객체의 내부 상태가 변경될 때 해당 객체가 그의 행동을 변경할 수 있도록 하는 행동 디자인 패턴입니다. 객체가 행동을 변경할
 * 때 객체가 클래스를 변경한 것처럼 보일 수 있습니다.
 * 
 * 상태는 유한 하애 합니다. 상태별로 알고리즘이 달라집니다. 그리고 각 상태는 다른 상태로 전이할 수 있습니다. 단, 전이는 미리 정해진
 * 상태로만 가능합니다.
 * 
 * 전략 패턴과 유사한 점이 있지만, 중요한 차이는
 * 전략 패턴은 각 알고리즘(전략)이 서로를 알지 못합니다.
 * 상태 패턴은 각 알고리즘(상태)이 서로를 식별하고 전이할 수 있습니다.
 * 
 * #구성 요소
 * Context
 * 구상 상태 객체 중 하나에 대한 참조를 저장하고 
 * 모든 상태별 작업을 그곳에 위임합니다. 
 * 콘텍스트는 상태 인터페이스를 통해 상태 객체와 통신하며, 
 * 새로운 상태 객체를 전달하기 위한 세터​(setter)​를 노출합니다.
 * 
 * State
 * 메서드들을 선언합니다. 이러한 메서드들은 모든 구상 상태에서 유효해야 합니다. 
 * 왜냐하면 당신은 결코 호출될 일 없는 쓸모없는 메서드들이 
 * 일부 상태 내에 존재하는 것은 원하지 않을 것이기 때문입니다.
 * 
 * ConcreteState
 * 구상 상태들은 상태별 메서드들에 대한 자체적인 구현을 제공합니다. 
 * 여러 상태에서 유사한 코드의 중복을 피하기 위하여 
 * 어떤 공통 행동을 캡슐화하는 중간 추상 클래스들을 제공할 수 있습니다
 * 상태 객체들은 콘텍스트 객체에 대한 역참조를 저장할 수 있습니다. 
 * 이 참조를 통해 상태는 콘텍스트 객체에서 모든 필요한 정보를 
 * 가져올 수 있고 상태 천이를 시작할 수 있습니다.
 * 
 * 
 * 상태 패턴은 현재 상태에 따라 다르게 행동하는 객체가 있을 때, 상태들의 수가 많을 때, 그리고 상태별 코드가 자주 변경될 때 사용하세요.
 * 이 패턴은 당신이 클래스 필드들의 현재 값들에 따라 클래스가 행동하는 방식을 변경하는 거대한 조건문들로 오염된 클래스가 있을 때 사용하세요.
 * 상태 패턴은 유사한 상태들에 중복 코드와 조건문-기반 상태 머신의 천이가 많을 때 사용하세요.
 */
public class Temp {
	public static void main(String[] args) {
	}
}
