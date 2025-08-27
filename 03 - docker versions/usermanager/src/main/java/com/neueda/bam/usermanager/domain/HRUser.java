package com.neueda.bam.usermanager.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HRUser {
    private String gender;
    private Name name;
    private Location location;
    private String email;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "HRUserDto{" +
                "gender='" + gender + '\'' +
                ", name=" + name +
                ", location=" + location +
                ", email='" + email + '\'' +
                '}';
    }

    public User toUser() {
        return new User(null,
                name.getTitle() , name.getFirst() , name.getLast(),
                location.getStreet().getNumber() + " " + location.getStreet().getName() + ", "
                        + location.getCity() + ", " + location.getState() + ", " + location.getPostcode()
                        + ", " + location.getCountry(),
                email);
    }

    public static class Name {
        private String title;
        private String first;
        private String last;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        @Override
        public String toString() {
            return "Name{" +
                    "title='" + title + '\'' +
                    ", first='" + first + '\'' +
                    ", last='" + last + '\'' +
                    '}';
        }
    }

    public static class Street {
        private Integer number;
        private String name;

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Street{" +
                    "number=" + number +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class Location {
        private Street street;
        private String city;
        private String state;
        private String postcode;

        private String country;


        public Street getStreet() {
            return street;
        }

        public void setStreet(Street street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "street=" + street +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", postcode='" + postcode + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }

    }


}
