package io.swagger.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.MappedSuperclass;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * PersonData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-21T05:01:38.936Z")

@MappedSuperclass
public class PersonData implements Serializable   {
	
  @JsonProperty("survived")
  private Boolean survived = null;

  @JsonProperty("passengerClass")
  private Integer passengerClass = null;


  @JsonProperty("name")
  private String name = null;

  /**
   * Gets or Sets sex
   */
  public enum SexEnum {
    MALE("male"),
    
    FEMALE("female"),
    
    OTHER("other");

    private String value;

    SexEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SexEnum fromValue(String text) {
      for (SexEnum b : SexEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("sex")
  private String sex = null;

  @JsonProperty("age")
  private Integer age = null;

  @JsonProperty("siblingsOrSpousesAboard")
  private Integer siblingsOrSpousesAboard = null;

  @JsonProperty("parentsOrChildrenAboard")
  private Integer parentsOrChildrenAboard = null;

  @JsonProperty("fare")
  private BigDecimal fare = null;

  public PersonData survived(Boolean survived) {
    this.survived = survived;
    return this;
  }

  /**
   * Get survived
   * @return survived
  **/
  @ApiModelProperty(value = "")


  public Boolean isSurvived() {
    return survived;
  }

  public void setSurvived(Boolean survived) {
    this.survived = survived;
  }

  public PersonData passengerClass(Integer passengerClass) {
    this.passengerClass = passengerClass;
    return this;
  }

  /**
   * Get passengerClass
   * @return passengerClass
  **/
  @ApiModelProperty(value = "")


  public Integer getPassengerClass() {
    return passengerClass;
  }

  public void setPassengerClass(Integer passengerClass) {
    this.passengerClass = passengerClass;
  }

  public PersonData name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PersonData sex(String sex) {
    this.sex = sex;
    return this;
  }

  /**
   * Get sex
   * @return sex
  **/
  @ApiModelProperty(value = "")


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public PersonData age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * @return age
  **/
  @ApiModelProperty(value = "")


  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public PersonData siblingsOrSpousesAboard(Integer siblingsOrSpousesAboard) {
    this.siblingsOrSpousesAboard = siblingsOrSpousesAboard;
    return this;
  }

  /**
   * Get siblingsOrSpousesAboard
   * @return siblingsOrSpousesAboard
  **/
  @ApiModelProperty(value = "")


  public Integer getSiblingsOrSpousesAboard() {
    return siblingsOrSpousesAboard;
  }

  public void setSiblingsOrSpousesAboard(Integer siblingsOrSpousesAboard) {
    this.siblingsOrSpousesAboard = siblingsOrSpousesAboard;
  }

  public PersonData parentsOrChildrenAboard(Integer parentsOrChildrenAboard) {
    this.parentsOrChildrenAboard = parentsOrChildrenAboard;
    return this;
  }

  /**
   * Get parentsOrChildrenAboard
   * @return parentsOrChildrenAboard
  **/
  @ApiModelProperty(value = "")


  public Integer getParentsOrChildrenAboard() {
    return parentsOrChildrenAboard;
  }

  public void setParentsOrChildrenAboard(Integer parentsOrChildrenAboard) {
    this.parentsOrChildrenAboard = parentsOrChildrenAboard;
  }

  public PersonData fare(BigDecimal fare) {
    this.fare = fare;
    return this;
  }

  /**
   * Get fare
   * @return fare
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getFare() {
    return fare;
  }

  public void setFare(BigDecimal fare) {
    this.fare = fare;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonData personData = (PersonData) o;
    return Objects.equals(this.survived, personData.survived) &&
        Objects.equals(this.passengerClass, personData.passengerClass) &&
        Objects.equals(this.name, personData.name) &&
        Objects.equals(this.sex, personData.sex) &&
        Objects.equals(this.age, personData.age) &&
        Objects.equals(this.siblingsOrSpousesAboard, personData.siblingsOrSpousesAboard) &&
        Objects.equals(this.parentsOrChildrenAboard, personData.parentsOrChildrenAboard) &&
        Objects.equals(this.fare, personData.fare);
  }

  @Override
  public int hashCode() {
    return Objects.hash(survived, passengerClass, name, sex, age, siblingsOrSpousesAboard, parentsOrChildrenAboard, fare);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonData {\n");
    
    sb.append("    survived: ").append(toIndentedString(survived)).append("\n");
    sb.append("    passengerClass: ").append(toIndentedString(passengerClass)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    siblingsOrSpousesAboard: ").append(toIndentedString(siblingsOrSpousesAboard)).append("\n");
    sb.append("    parentsOrChildrenAboard: ").append(toIndentedString(parentsOrChildrenAboard)).append("\n");
    sb.append("    fare: ").append(toIndentedString(fare)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

