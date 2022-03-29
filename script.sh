resp=$(curl -X 'GET' \
         'https://api.spaceflightnewsapi.net/v3/articles/count' \
         -H 'accept: application/json')
echo "$resp"