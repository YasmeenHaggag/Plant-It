use planit;
INSERT INTO places (name, avgRate,avgPrice,type,town,location,googleMapsUrl,lat,lon,imageCover,reviews)
VALUES ('Grand Nile Tower',
        5,400,'Hotel','Cairo','Corniche El Nile, Garden City, Cairo, Egypt','https://www.google.com/maps/place/Grand+Nile+Tower/@30.0342741,31.2243435,17z/data=!4m9!3m8!1s0x14584090695d6421:0x201285387107863a!5m2!4m1!1i2!8m2!3d30.0342741!4d31.2269184!16s%2Fm%2F0cm8f4m?authuser=0&entry=ttu',
        30.0342741,31.2243435,'https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/66/32/88/grand-nile-tower.jpg?w=1100&h=-1&s=1',
        'Great service and comfortable rooms.'
        );

use planit;
INSERT INTO plans (user_id,items)
VALUES ('fghjb54213klu66','["Grand Nile Tower", "Fairmont Nile City"]'
       );