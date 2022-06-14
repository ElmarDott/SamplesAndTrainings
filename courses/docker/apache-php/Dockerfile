FROM php:8.1.6-apache
MAINTAINER Elmar Dott (elmar.dott@gmail.com) 

RUN \
  apt-get update && \
  apt-get install -y --no-install-recommends \
    exim4 \
    postgresql-client \
    libpq-dev \
    libwebp-dev \
    libpng-dev \
    libjpeg62-turbo-dev \
    libzip-dev \
    libxpm-dev \
    libfreetype6-dev \
    zlib1g-dev \
    libmcrypt-dev \
    libmagickwand-dev && \
  docker-php-ext-install exif zip gd soap pgsql pdo pdo_pgsql && \
  pecl install imagick && \
  docker-php-ext-configure pgsql -with-pgsql=/usr/local/pgsql && \
  docker-php-ext-install mysqli pdo_mysql && \
  apt-get clean && \
  rm -rf /var/lib/apt/lists/* /etc/rsyslog.conf

## Das image erstellen:
##   docker build /path/to/the/DOCKERFILE/ -t php-container:8.1.6
