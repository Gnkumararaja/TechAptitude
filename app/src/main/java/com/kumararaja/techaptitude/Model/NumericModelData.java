package com.kumararaja.techaptitude.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class NumericModelData implements Parcelable{

    String numericValues;

    public NumericModelData(String numericValues){
        this.numericValues=numericValues;
    }

    protected NumericModelData(Parcel in) {
        numericValues = in.readString();
    }

    public static final Creator<NumericModelData> CREATOR = new Creator<NumericModelData>() {
        @Override
        public NumericModelData createFromParcel(Parcel in) {
            return new NumericModelData(in);
        }

        @Override
        public NumericModelData[] newArray(int size) {
            return new NumericModelData[size];
        }
    };

    public String getNumericValues() {
        return numericValues;
    }

    public void setNumericValues(String numericValues) {
        this.numericValues = numericValues;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(numericValues);
    }

    public static class Verbal implements Parcelable{
        String verbalNames;

        public Verbal(String verbalNames) {
            this.verbalNames = verbalNames;
        }

        protected Verbal(Parcel in) {
            verbalNames = in.readString();
        }

        public static final Creator<Verbal> CREATOR = new Creator<Verbal>() {
            @Override
            public Verbal createFromParcel(Parcel in) {
                return new Verbal(in);
            }

            @Override
            public Verbal[] newArray(int size) {
                return new Verbal[size];
            }
        };

        public String getVerbalNames() {
            return verbalNames;
        }

        public void setVerbalNames(String verbalNames) {
            this.verbalNames = verbalNames;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(verbalNames);
        }
    }

    public static class Analytic implements Parcelable {
        String name;

        public Analytic(String names) {
            name = names;

        }

        protected Analytic(Parcel in) {
            name = in.readString();
        }

        public static final Creator<Analytic> CREATOR = new Creator<Analytic>() {
            @Override
            public Analytic createFromParcel(Parcel in) {
                return new Analytic(in);
            }

            @Override
            public Analytic[] newArray(int size) {
                return new Analytic[size];
            }
        };

        public String getNames() {
            return name;
        }

        public void setNames(String names) {
            this.name = names;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
        }
    }

    public static class Taketest implements Parcelable{
        String types;

        public Taketest(String type) {
            this.types=type;
        }

        protected Taketest(Parcel in) {
            types = in.readString();
        }

        public static final Creator<Taketest> CREATOR = new Creator<Taketest>() {
            @Override
            public Taketest createFromParcel(Parcel in) {
                return new Taketest(in);
            }

            @Override
            public Taketest[] newArray(int size) {
                return new Taketest[size];
            }
        };

        public String getTypes() {
            return types;
        }

        public void setTypes(String types) {
            this.types = types;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(types);
        }
    }

}



