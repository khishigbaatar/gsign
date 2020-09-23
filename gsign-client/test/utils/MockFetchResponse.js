export const mockFetchResponse = (successResponseJson) => {
  return {
    then: (callbackFunction) => callbackFunction(successResponseJson)
  }
}

export const mockFetchResponseWithCatchReturn = (successResponseJson) => {
  return {
    then: (callbackFunction) => {
      return {
        catch: () =>
          callbackFunction(successResponseJson)
      }
    }
  }
}

export const mockFetchResponseWithCatch = (successResponseJson) => {
  return {
    then: (callbackFunction) => {
      callbackFunction(successResponseJson)

      return {
        catch: () => {
        }
      }
    }
  }
}

export const mockCatchResponse = (errorResponse) => {
  return {
    then: () => {
      return {
        catch: (errorFunction) => errorFunction(errorResponse)
      }
    }
  }
}

export const fetchWithoutCallback = () => {
  return {
    then: () => {
    }
  }
}
