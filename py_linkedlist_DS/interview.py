





# import json
# import requests
# from fastapi import FastAPI
# # from pydantic import  Basemodel, table, columns




# app = FastAPI()

# @app.get('/api/v1/service-name/get_heroes')
# async def get_top_heroes(power: str, intelligence: str=None, speed: str=None, strength: str= None, limit: int = 10):
#     power_list = intelligence_list = speed_list = strength_list = []
#     try:
#         response = await requests.get('https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/all.json')
#         if response.statuscod == 200:
#             json_response_list = response.json()[0]
#             for every_dict_ele in json_response_list:
#                 powerstates = every_dict_ele.get('powerstat')
#                 power_list.append(powerstates.get('power'))
#                 intelligence_list.append(powerstates.get('intelligence'))
#                 speed_list.append(powerstates.get('speed'))
#                 strength_list.append(powerstates.get('strength'))
#             power_list.sort(reverse=True)
#             intelligence_list.sort(reverse=True)
#             speed_list.sort(reverse=True)
#             strength_list.sort(reverse=True)
#             return {
#                 "power": power_list[:limit],
#                 "intelligence" : intelligence_list[:limit],
#                 "speed": speed_list[:limit],
#                 "strength": strength_list



#             }
#         else:
#             return 

            
#     except Exception as e:
#         return {"cause": "Exception Occured", exc_info=True, stack_info=True}

    



         
