import requests
import tweepy
import time
import os

SELDON_URL = os.environ.get("SELDON_URL", "http://35.233.20.148/seldon/kubeflow/nlp-kubeflow-pipeline/api/v0.1/predictions")
KEYWORD = os.environ.get("TWITTER_KEYWORD", "brexit")
consumer_key = os.environ["TWITTER_KEY"]
consumer_secret = os.environ["TWITTER_SECRET"]
access_token = os.environ["TWITTER_TOKEN"]
access_token_secret = os.environ["TWITTER_TOKEN_SECRET"]

class SeldonTweetListener(tweepy.StreamListener):
    ''' Handles data received from the stream. '''
 
    def on_status(self, status):
 
        try:
            payload = {
                "data": {
                    "names": ["text"],
                    "ndarray": [status.text.encode("utf-8").decode("latin-1")]
                }
            }
            print(payload)

            res = requests.post(
                SELDON_URL,
                auth=('admin', '41luke'),
                json=payload)
        except:
            pass

        return True
 
    def on_error(self, status_code):
        return True # To continue listening
 
    def on_timeout(self):
        return True # To continue listening
 
if __name__ == '__main__':

    listener = SeldonTweetListener()
    auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
    auth.set_access_token(access_token, access_token_secret)

 
    while True:
        try:
            stream = tweepy.Stream(auth, listener)
            stream.filter(track=[KEYWORD])
        except:
            pass
        time.sleep(10)



