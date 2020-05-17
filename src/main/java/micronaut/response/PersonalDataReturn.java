package micronaut.response;

public class PersonalDataReturn {

	/** ID e.g. 1 */
	public Integer id;
	
	/** 姓 e.g. 山田 */
    public String sei;

    /** 名 e.g. 太郎 */
    public String mei;

	public PersonalDataReturn(Integer id, String sei, String mei) {
		super();
		this.id = id;
		this.sei = sei;
		this.mei = mei;
	}
}
