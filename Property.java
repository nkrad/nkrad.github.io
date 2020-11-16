public class Property{
  public String name;
  public int price;
  public Colour colour;
  public int boardPlace;
  public boolean bought;
  public Type type;
  public int rent;
  public int house;

    public Property(String name, int price, Colour colour, int boardPlace, boolean bought, Type type, int rent, int house){
      this.name = name;
      this.price = price;
      this.colour = colour;
      this.boardPlace = boardPlace;
      this.bought = false;
      this.type = type;
      this.rent = rent;
      this.house = house;
    }

    //getter for place
    public int getBoardPlace(){
      return boardPlace;
    }

    //getter for price
    public int getPrice(){
      return price;
    }

    //getter for name
    public String getName(){
      return name;
    }

    //getter for colour
    public Colour getColour(){
      return colour;
    }

    //getter for bought
    public boolean getBought(){
      return bought;
    }

    //getter for type
    public Type getType(){
      return type;
    }

    //getter for rent
    public int getRent(){
      return rent;
    }

    //getter for # of houses
    public int getHouse(){
      return house;
    }

    //setter for bought
    public boolean setBuy(){
      bought = true;
      return bought;
    }
    //setter for houses
    public int addHouse(){
      house += 1;
      return house;
    }

    //setter for rent from houses
    public int setRent(){
      if(colour == Colour.LIGHTBLUE){
        if(house == 1){
          rent = 35;
        }else if(house == 2){
          rent = 95;
        }else if(house == 3){
          rent = 285;
        }else if(house == 4){
          rent = 425;
        }else if(house == 5){
          rent = 575;
        }
      }else if(colour == Colour.BROWN){
        if(house == 1){
          rent = 15;
        }else if(house == 2){
          rent = 45;
        }else if(house == 3){
          rent = 135;
        }else if(house == 4){
          rent = 240;
        }else if(house == 5){
          rent = 350;
        }
      }else if(colour == Colour.PINK){
        if(house == 1){
          rent = 55;
        }else if(house == 2){
          rent = 165;
        }else if(house == 3){
          rent = 475;
        }else if(house == 4){
          rent = 665;
        }else if(house == 5){
          rent = 825;
        }
      }else if(colour == Colour.ORANGE){
        if(house == 1){
          rent = 75;
        }else if(house == 2){
          rent = 210;
        }else if(house == 3){
          rent = 575;
        }else if(house == 4){
          rent = 775;
        }else if(house == 5){
          rent = 975;
        }
      }else if(colour == Colour.RED){
        if(house == 1){
          rent = 95;
        }else if(house == 2){
          rent = 275;
        }else if(house == 3){
          rent = 725;
        }else if(house == 4){
          rent = 900;
        }else if(house == 5){
          rent = 1075;
        }
      }else if(colour == Colour.YELLOW){
        if(house == 1){
          rent = 115;
        }else if(house == 2){
          rent = 345;
        }else if(house == 3){
          rent = 825;
        }else if(house == 4){
          rent = 1000;
        }else if(house == 5){
          rent = 1175;
        }
      }else if(colour == Colour.GREEN){
        if(house == 1){
          rent = 140;
        }else if(house == 2){
          rent = 420;
        }else if(house == 3){
          rent = 950;
        }else if(house == 4){
          rent = 1150;
        }else if(house == 5){
          rent = 1325;
        }
      }else if(colour == Colour.BLUE){
        if(house == 1){
          rent = 190;
        }else if(house == 2){
          rent = 550;
        }else if(house == 3){
          rent = 1250;
        }else if(house == 4){
          rent = 1500;
        }else if(house == 5){
          rent = 1750;
        }
      }
      
      return rent;
    }

    //toString method
    public String toString(){
      return "" + name + ".";
    }
  }

