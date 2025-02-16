package com.example.demo.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.MemberRole;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="member")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	@Id
	private String id;
	@Column(updatable = false)
	private String password; //수정할때 단독으로 수정해야함. 즉 , 업데이트시 별도.
	private String name;
	private int age;
	private int jno;
	private String info;
	private double point;
	private String birthday;
	private String rid;
	private String uploadfile;
	@Transient //SQL 구문처리에서 제외시켜줌
	private MultipartFile uploadfilef;
	
	
	/*~~ Spring Security 인증기능 추가 ~~~~~~~~~~~~~~~~~~~~~~
    
	    ** @ElementCollection (JPA)
	    => RDB에는 컬렉션과 같은 형태의 데이터를 컬럼에 저장할 수 없기 때문에, 
	        별도의 테이블을 생성하여 컬렉션을 관리해야한다.
	        이때 컬렉션 객체임을 JPA에게 알려주는 애너테이션
	     
	    => JPA는 @Entity가 아닌 Basic Type이나 Embeddable Class로 정의된 컬렉션을
	        테이블로 생성하며 One-To-Many 관계를(1:N)다룬다.

	    => 생성된 컬렉션 Table 특징 
	        -> Entity 와 라이프 싸이클을 같이 하며 독립적으로 사용불가능.
	        -> 부모 Entity가 삭제될 경우 같이 삭제됨.
	         ( 실제 클래스에 cascade 를 설정하는 옵션 없음. )
	        -> ElementCollection의 Fetch 전략은 기본이 Lazy 임.
	        -> 실제 테이블은 FK를 이용해서 생성됨.    

	    ** @Builder.Default
	     => 빌더패턴으로 생성 & 초기화 할때, 정의하지 않아도 기본으로 적용되는 default 값을 정의함
	         아래의 경우 빌더패턴에서 memberRoleList 를 초기화 하지 않으면 null 값이지만, 
	         @Builder.Default 를 붙여주면 ArrayList로 초기화된다.
	        private List<MemberRole> memberRoleList = new ArrayList<>();
	    */
	@ElementCollection(fetch = FetchType.LAZY)
	@Builder.Default
	private List<MemberRole> roleList = new ArrayList<>();
	
	public void addRole(MemberRole memberRole) {
		roleList.add(memberRole);
	}
	
	public void clearRole() {
		roleList.clear();
	}
	
    // => JWT token 발행시 사용됨
    //    로그인 성공 후 createToken() 에 인자로 사용됨
    public Map<String, Object> claimList() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("userId", this.id);
        //dataMap.put("pw",this.password);
        dataMap.put("roleList", this.roleList);

        return dataMap;
    }
}
