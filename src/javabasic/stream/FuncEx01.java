package javabasic.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FuncEx01 {
	static class User{
		final Long id;
		final String name;
		final Integer age;
		
		public User(Long id, String name, Integer age) {
			this.id = id;
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "[id=" + id + ", name=" + name + ", age=" + age + "]\n";
		}
		
	}
	
	static List<User> getUsers(){
		return Arrays.asList( 
				new User(10L, "ID", 36),
				new User(20L, "BJ", 32),
				new User(30L, "JM", 32),
				new User(40L, "PJ", 27),
				new User(50L, "HA", 25),
				new User(60L, "JE", 26),
				new User(70L, "JI", 31),
				new User(80L, "MP", 23)
				);
	}
	
	
	public static void main(String[] args) {
		List<User> users = getUsers();
		
		System.out.println("filter = "+
				filter(users,user->user.age>30)+"\n"
				+users
				);
		
		System.out.println("map = "+
				map(users, user->user.id)
				);
		
		each(Arrays.asList(1,2,3,4,5),System.out::print);
		System.out.println();
		
	}
	/*
	 * filter는 처리 결과가 입력 결과와 타입은 같다.
	 * 길이는 같거나, 작을 수 밖에 없다.
	 */
	static <T> List<T> filter(List<T> list, Predicate<T> predi) {
		//함수형 프로그래밍은 원본 데이터를 수정하지 않는다. 새로운 데이터를 리턴하여
		//부수효과를 극단적으로 배제한다.
		ArrayList<T> newList = new ArrayList<>();
		each(list,data->{
			if(predi.test(data))
				newList.add(data);
		});
		
		return newList;
	}
	/*
	 * map은 처리 결과가 입력 결과와 타입은 같거나 다르다.
	 * 길이는 항상 같다.
	 */
	static <T,R> List<R> map(List<T> list, Function<T, R> mapper){
		ArrayList<R> newList = new ArrayList<>();
		each(list, data->{
			newList.add(mapper.apply(data));
		});
		return newList;
	}
	/*
	 * 반복문을 중복을 대체할 함수
	 */
	static <T> List<T> each(List<T> list, Consumer<T> iter){
		for(T data : list) 
			iter.accept(data);
		return list;
	}
	
}
