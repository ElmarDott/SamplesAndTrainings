FROM php:7.4.29-apache
MAINTAINER Elmar Dott (elmar.dott@gmail.com) 

RUN apt-get update
RUN apt-get upgrade -y

RUN apt-get install -y libwebp-dev postgresql-client libpng-dev libjpeg62-turbo-dev libzip-dev libxpm-dev libfreetype6-dev zlib1g-dev libmcrypt-dev libpq-dev libmagickwand-dev --no-install-recommends
    
RUN docker-php-ext-install exif zip mysqli pgsql pdo pdo_mysql pdo_pgsql gd soap \
     && pecl install imagick 

RUN docker-php-ext-configure pgsql -with-pgsql=/usr/local/pgsql



## Das image erstellen:
##   docker /path/to/the/DOCKERFILE/ build -t php-container:7.4.29
