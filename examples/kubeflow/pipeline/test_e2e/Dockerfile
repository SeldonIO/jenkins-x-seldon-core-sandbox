FROM python:3

RUN apt-get update -y
RUN apt-get install -y python-pip python-dev build-essential

RUN mkdir /app
WORKDIR /app

COPY . /app/.

RUN pip install tweepy

CMD python /app/run_stream.py

