package models;

import java.util.HashMap;
import java.util.Iterator;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Station extends Model
{
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();
 public double latitude;
 public double longitude;
  public double celcius;
  public double fahrenheit;
  public int windBeaufort;
  public int pressure;

  public String weatherCodes;


  public String name;
  public Station(String name)
  {
    this.name = name;
  }
  public int pressure(int pressure){ return pressure;}

  public static String codeToText(int code)
  {
    HashMap <Integer, String> weatherCodes = new HashMap<>();

    weatherCodes.put(100, "Clear");
    weatherCodes.put(200, "Partial clouds");
    weatherCodes.put(300, "Cloudy");
    weatherCodes.put(400, "Light showers");
    weatherCodes.put(500, "Heavy showers");
    weatherCodes.put(600, "Rain");
    weatherCodes.put(700, "Snow");
    weatherCodes.put(800, "Thunder");

    return weatherCodes.get(code);
  }


  public static double calculateCelcius(double celcius, double temperature)
  {
    celcius = temperature;
    return celcius;
  }

  public static double calculateFahrenheit(double fahrenheit, double temperature)
  {
    fahrenheit= temperature * 9 / 5 + 32;
    return fahrenheit;
  }

  public static int windBeaufort(double windSpeed)
  {
    if (windSpeed <= 1){
      return 0;
    } else if (windSpeed > 1 || windSpeed <= 5){
      return 1;
    } else if (windSpeed >= 6 || windSpeed <= 11) {
      return 2;
    } else if (windSpeed >= 12 || windSpeed <= 19) {
      return 3;
    } else if (windSpeed >= 20|| windSpeed <= 28) {
      return 4;
    } else if (windSpeed >= 29 || windSpeed <= 38) {
      return 5;
    } else if (windSpeed >= 39 || windSpeed <= 49) {
      return 6;
    } else if (windSpeed >= 50 || windSpeed <= 61) {
      return 7;
    } else if (windSpeed >= 62 || windSpeed <= 74) {
      return 8;
    } else if (windSpeed >= 75 || windSpeed <= 88) {
      return 9;
    } else if (windSpeed >= 89 || windSpeed <= 102) {
      return 10;
    } else {
      return 11;
    }
  }
}

